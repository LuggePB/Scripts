package biz.lugge.scripts.rs3.luckykebbit.task;

import biz.lugge.scripts.rs3.luckykebbit.LuckyKebbitV2;
import biz.lugge.scripts.rs3.luckykebbit.data.ObjectBuffer;
import biz.lugge.scripts.rs3.luckykebbit.data.Path;
import biz.lugge.scripts.rs3.luckykebbit.data.Tracks;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Actions extends ClientAccessor {
    public Actions(ClientContext ctx) {
        super(ctx);
    }

    private Tracks nextTrack;
    private ObjectBuffer oB = new ObjectBuffer(ctx);

    public void climbStairs() {
        LuckyKebbitV2.paint.setStatus("Climb Stairs");
        ctx.objects.select(5).name("Stairs").nearest().poll().interact("Climb");
        Condition.wait(() -> ctx.game.floor() == 0, 200, 5);
    }

    public void followTrack() {
        if (ctx.varpbits.varpbit(1218) == 0) {
            if (nextTrack == null) {
                nextTrack = Tracks.SH;
            }
        } else {
            for (Tracks track : Tracks.values()) {
                if (ctx.varpbits.varpbit(1218) == track.getVarpbitSetting()) {
                    nextTrack = track;
                }
            }
        }

        GameObject nextObject = oB.getGameObject(nextTrack);


        if (!nextObject.inViewport()) {
            LuckyKebbitV2.paint.setStatus("Turn Cam");
            ctx.camera.turnTo(nextObject);
            if (!nextObject.inViewport()) {
                LuckyKebbitV2.paint.setStatus("Walk");
                ctx.movement.step(nextObject);
                Condition.wait(() -> nextObject.inViewport() && !ctx.players.local().inMotion(), 200, 5);
            }
        }

        if (nextTrack.getFinalTile() != Tile.NIL) {
            LuckyKebbitV2.paint.setStatus("Attack");
            nextObject.interact("Attack");
            Condition.wait(() -> ctx.varpbits.varpbit(1218) == 0, 500, 5);
            nextTrack = null;
        } else {
            LuckyKebbitV2.paint.setStatus("Inspect");
            nextObject.interact("Inspect");
            Condition.wait(() -> ctx.varpbits.varpbit(1218) != nextTrack.getVarpbitSetting(), 500, 5);
        }

    }

    public void cleanInventory() {
        LuckyKebbitV2.paint.setStatus("Clean Inv");
        ctx.backpack.select().id(526, 9986).peek().interact("Drop");
        Condition.wait(() -> !ctx.backpack.poll().valid(), 200, 5);
    }

    public void walkBank() {
        LuckyKebbitV2.paint.setStatus("Walk");
        ctx.movement.newTilePath(Path.BOTH_WAYS.getPath()).reverse().randomize(1, 1).traverse();
    }

    public void bank() {
        if (ctx.bank.opened()) {
            LuckyKebbitV2.paint.setStatus("Bank");
            if (ctx.backpack.select().isEmpty()) {
                ctx.bank.close();
                Condition.wait(() -> !ctx.bank.opened(), 200, 5);
            } else {
                ctx.bank.depositInventory();
                Condition.wait(() -> ctx.backpack.select().isEmpty(), 200, 5);
            }
        } else {
            LuckyKebbitV2.paint.setStatus("Open Bank");
            ctx.bank.open();
            Condition.wait(ctx.bank::opened, 200, 5);
        }
    }

    public void walkLocation() {
        LuckyKebbitV2.paint.setStatus("Walk");
        ctx.movement.newTilePath(Path.BOTH_WAYS.getPath()).randomize(1, 1).traverse();
    }
}