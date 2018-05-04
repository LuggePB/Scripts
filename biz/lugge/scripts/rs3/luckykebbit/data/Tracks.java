package biz.lugge.scripts.rs3.luckykebbit.data;

import org.powerbot.script.Tile;

public enum Tracks {
    //START_ HOLE_PATH_#_STEP_#_OPTION_#
    SH(1, 66473, Tile.NIL),

    SHP1S1(49152, 66472, Tile.NIL),
    SHP1S2(1073857024, 66470, Tile.NIL),
    SHP1S3(1342293504, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    SHP2S1(1544, 66468, Tile.NIL),
    SHP2S2O1(1073743386, 66467, Tile.NIL),
    SHP2S2O2(1073743448, 66469, Tile.NIL),
    SHP2S3O1(1342178844, 66496, Tiles.WEST_SNOW_PILE.getTile()),
    SHP2S3O2(1476396760, 66496, Tiles.EAST_SNOW_PILE.getTile()),

    SHP3S1(131200, 66469, Tile.NIL),
    SHP3S2O1(1073873154, 66467, Tile.NIL),
    SHP3S2O2(1073873168, 66468, Tile.NIL),
    SHP3S3O1(1342308612, 66496, Tiles.WEST_SNOW_PILE.getTile()),
    SHP3S3O2(1342308640, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    SHP4S1(135168, 66471, Tile.NIL),
    SHP4S2(1073885696, 66470, Tile.NIL),
    SHP4S3(1342322176, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    SHP5S1(1537, 66467, Tile.NIL),
    SHP5S2O1(1073743427, 66469, Tile.NIL),
    SHP5S2O2(1073743379, 66468, Tile.NIL),
    SHP5S3O1(1476396739, 66496, Tiles.EAST_SNOW_PILE.getTile()),
    SHP5S3O2(1342178851, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    SHP6S1(16512, 66469, Tile.NIL),
    SHP6S2O1(1073758466, 66467, Tile.NIL),
    SHP6S2O2(1073758480, 66468, Tile.NIL),
    SHP6S3O1(1342193924, 66496, Tiles.WEST_SNOW_PILE.getTile()),
    SHP6S3O2(1342193952, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    NH(2, 66473, Tile.NIL),

    NHP1S1(1028, 66470, Tile.NIL),
    NHP1S2O1(1073809412, 66472, Tile.NIL),
    NHP1S2O2(1073752068, 66471, Tile.NIL),
    NHP1S3O1(1476528132, 66496, Tiles.EAST_SNOW_PILE.getTile()),
    NHP1S3O2(1476413444, 66496, Tiles.EAST_SNOW_PILE.getTile()),

    NHP2S1(12, 66468, Tile.NIL),
    NHP2S2O1(1073741916, 66469, Tile.NIL),
    NHP2S202(1073809412, 66472, Tile.NIL),
    NHP2S3O1(1476395228, 66496, Tiles.EAST_SNOW_PILE.getTile()),
    NHP2S3O2(1476528132, 66496, Tiles.EAST_SNOW_PILE.getTile()),

    NHP3S1(33, 66467, Tile.NIL),
    NHP3S2(1073741923, 66469, Tile.NIL),
    NHP3S3(1476395235, 66496, Tiles.EAST_SNOW_PILE.getTile()),

    NHP4S1(4288, 66471, Tile.NIL),
    NHP4S2O1(1073819840, 66472, Tile.NIL),
    NHP4S2O2(1073754816, 66470, Tile.NIL),
    NHP4S3O1(1476538560, 66496, Tiles.EAST_SNOW_PILE.getTile()),
    NHP4S3O2(1342191296, 66496, Tiles.WEST_SNOW_PILE.getTile()),

    NHP5S1(1056, 66470, Tile.NIL),
    NHP5S2O1(1073752096, 66471, Tile.NIL),
    NHP5S2O2(1073809440, 66472, Tile.NIL),
    NHP5S3O1(1476413472, 66496, Tiles.EAST_SNOW_PILE.getTile()),
    NHP5S3O2(1476528160, 66496, Tiles.EAST_SNOW_PILE.getTile()),

    NHP6S1(32960, 66472, Tile.NIL),
    NHP6S2O1(1073840832, 66470, Tile.NIL),
    NHP6S2O2(1073848512, 66471, Tile.NIL),
    NHP6S3O1(1342277312, 66496, Tiles.WEST_SNOW_PILE.getTile()),
    NHP6S3O2(1476509888, 66496, Tiles.EAST_SNOW_PILE.getTile());

    private final int varpbitSetting;
    private final int nextObjectID;
    private final Tile finalTile;

    Tracks(int varpbitSetting, int nextObjectID, Tile finalTile) {
        this.varpbitSetting = varpbitSetting;
        this.nextObjectID = nextObjectID;
        this.finalTile = finalTile;
    }

    public final int getVarpbitSetting() {
        return varpbitSetting;
    }

    public final int getNextObjectID() {
        return nextObjectID;
    }

    public final Tile getFinalTile() {
        return finalTile;
    }
}
