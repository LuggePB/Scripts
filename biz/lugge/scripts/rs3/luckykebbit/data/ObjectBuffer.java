package biz.lugge.scripts.rs3.luckykebbit.data;

import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientAccessor;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import java.util.HashMap;

public class ObjectBuffer extends ClientAccessor {

    public ObjectBuffer(ClientContext arg0) {
        super(arg0);
    }

    private HashMap<Integer, GameObject> bufferedObjects = new HashMap<>();
    private int[] objectIDs = new int[]{66472, 66470, 66496, 66467, 66469, 66468, 66471, 66473};

    private long init() {
        long startTime = System.currentTimeMillis();
        bufferedObjects.clear();
        ctx.objects.select(25).id(objectIDs);

        for (Tracks track : Tracks.values()) {
            if (track.getFinalTile() == Tile.NIL) {
                for (GameObject gameObject : ctx.objects) {
                    if (gameObject.id() == track.getNextObjectID()) {
                        bufferedObjects.put(track.getVarpbitSetting(), gameObject);
                        break;
                    }
                }
            } else {
                bufferedObjects.put(track.getVarpbitSetting(), ctx.objects.nearest(track.getFinalTile()).peek());
            }
        }
        return System.currentTimeMillis() - startTime;
    }

    public GameObject getGameObject(Tracks track) {
        GameObject gO = bufferedObjects.get(track.getVarpbitSetting());
        if (gO == null || !gO.valid()) {
            init();
            if (!ctx.controller.isSuspended() || !ctx.controller.isStopping()) {
                gO = getGameObject(track,4);
            }
        }
        return gO;
    }

    private GameObject getGameObject(Tracks track, int i) {
        GameObject gO = bufferedObjects.get(track.getVarpbitSetting());
        if (gO == null || !gO.valid()) {
            init();
            if (i>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gO = getGameObject(track, i-1);
            }
        }
        return gO;
    }
}