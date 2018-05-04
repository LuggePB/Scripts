package biz.lugge.scripts.rs3.luckykebbit.task;

import biz.lugge.scripts.rs3.luckykebbit.data.Tiles;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;

public class Conditions extends ClientAccessor {
    public Conditions(ClientContext ctx) {
        super(ctx);
    }

    public States getCurrentState() {
        if (ctx.game.floor() == 1) {
            return States.CLIMB_STAIRS;
        }

        if (!ctx.backpack.select().id(526, 9986).isEmpty()) {
            return States.CLEAN_INVENTORY;
        }

        if (ctx.backpack.select().count() >= 26) {
            if (ctx.players.local().tile().distanceTo(Tiles.BANK_POINT.getTile()) >= 5) {
                return States.WALK_BANK;
            } else {
                return States.BANK;
            }
        }

        if (ctx.players.local().tile().distanceTo(Tiles.CENTER_POINT.getTile()) > 10) {
            return States.WALK_LOCATION;
        }

        if (ctx.players.local().animation() == -1 && !ctx.players.local().inMotion()) {
            return States.FOLLOW_TRACK;
        }
        return States.IDLE;
    }
}
