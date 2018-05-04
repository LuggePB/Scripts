package biz.lugge.scripts.rs3.luckykebbit;

import biz.lugge.scripts.rs3.luckykebbit.task.Actions;
import biz.lugge.scripts.rs3.luckykebbit.task.Conditions;
import biz.lugge.scripts.rs3.luckykebbit.util.Paint;
import biz.lugge.scripts.rs3.luckykebbit.util.Time;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GeItem;

import java.awt.*;

@Script.Manifest(name = "LuckyKebbitV2", description = "polar kebbit hunter, f2p moneymaking", properties = "authors=Lugge; client=6; topic=1309755;")

public class LuckyKebbitV2 extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private final Conditions conditions = new Conditions(ctx);
    private final Actions actions = new Actions(ctx);

    public final static Paint paint = new Paint();
    public final static Time Time = new Time();

    private boolean started;

    @Override
    public void start() {
        if (ctx.game.loggedIn()) {
            paint.setStatus("starting");
            paint.setImage(downloadImage("http://img5.picload.org/image/rrcawpig/final4.png"));
            paint.setFurPrice(new GeItem(10117).price);
        } else {
            paint.setStatus("start logged in");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctx.controller.stop();
        }
        Time.setStartTime(System.currentTimeMillis());
        started = true;
    }

    @Override
    public void poll() {
        switch (conditions.getCurrentState()) {
            case CLIMB_STAIRS:
                actions.climbStairs();
                break;
            case FOLLOW_TRACK:
                actions.followTrack();
                break;
            case CLEAN_INVENTORY:
                actions.cleanInventory();
                break;
            case WALK_BANK:
                actions.walkBank();
                break;
            case BANK:
                actions.bank();
                break;
            case WALK_LOCATION:
                actions.walkLocation();
                break;
            case IDLE:
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        if (messageEvent.text().contains("You manage to noose")) {
            paint.setStatus("Track Finished");
            paint.setHuntedKebbits(paint.getHuntedKebbits() + 1);
            paint.setProfit(paint.getProfit() + paint.getFurPrice());
        }
    }


    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        g.setFont(paint.MAIN_FONT);
        g.setColor(Color.BLACK);
        g.drawImage(paint.getImage(), 0, 0, null);
        paint.drawMouse(g, ctx.input.getLocation());

        if (started) {
            g.drawString("" + Time.getRuntimeString(), 117, 45);
        } else {
            g.drawString("N/A", 117, 45);
        }

        g.drawString("" + paint.getStatus(), 117, 80);
        g.drawString("2.0", 269, 43);
        g.drawString("" + paint.getHuntedKebbits(), 363, 45);
        g.drawString("(" + paint.getProfit() / 1000 + "k gp)", 390, 45);

        paint.refresh(Time.getRuntime());
        g.drawString("" + paint.getHuntedKebbitsPerHour(), 363, 80);
        g.drawString("(" + paint.getProfitPerHour() / 1000 + "k gp)", 390, 80);


    }
}