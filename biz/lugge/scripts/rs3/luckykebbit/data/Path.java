package biz.lugge.scripts.rs3.luckykebbit.data;

import org.powerbot.script.Tile;

public enum Path {
    BOTH_WAYS(new Tile[]{
            new Tile(2875, 3417),
            new Tile(2876, 3417),
            new Tile(2877, 3417),
            new Tile(2878, 3417),
            new Tile(2879, 3417),
            new Tile(2880, 3417),
            new Tile(2880, 3418),
            new Tile(2880, 3419),
            new Tile(2880, 3420),
            new Tile(2880, 3421),
            new Tile(2880, 3422),
            new Tile(2880, 3423),
            new Tile(2880, 3424),
            new Tile(2880, 3425),
            new Tile(2880, 3426),
            new Tile(2880, 3427),
            new Tile(2880, 3428),
            new Tile(2880, 3429),
            new Tile(2880, 3430),
            new Tile(2880, 3431),
            new Tile(2880, 3432),
            new Tile(2881, 3433),
            new Tile(2882, 3434),
            new Tile(2882, 3435),
            new Tile(2882, 3436),
            new Tile(2882, 3437),
            new Tile(2882, 3438),
            new Tile(2882, 3439),
            new Tile(2882, 3440),
            new Tile(2882, 3441),
            new Tile(2882, 3442),
            new Tile(2882, 3443),
            new Tile(2882, 3444),
            new Tile(2882, 3445),
            new Tile(2882, 3446),
            new Tile(2882, 3448),
            new Tile(2882, 3449),
            new Tile(2882, 3450),
            new Tile(2882, 3451),
            new Tile(2882, 3452),
            new Tile(2882, 3453),
            new Tile(2882, 3454),
            new Tile(2882, 3455),
            new Tile(2882, 3456),
            new Tile(2882, 3457),
            new Tile(2882, 3458),
            new Tile(2881, 3459),
            new Tile(2881, 3460),
            new Tile(2881, 3461),
            new Tile(2881, 3462),
            new Tile(2881, 3463),
            new Tile(2881, 3464),
            new Tile(2881, 3465),
            new Tile(2881, 3466),
            new Tile(2881, 3467),
            new Tile(2881, 3468),
            new Tile(2881, 3469),
            new Tile(2881, 3470),
            new Tile(2881, 3471),
            new Tile(2881, 3472),
            new Tile(2880, 3472),
            new Tile(2880, 3473),
            new Tile(2880, 3474),
            new Tile(2880, 3475),
            new Tile(2880, 3476),
            new Tile(2880, 3477),
            new Tile(2880, 3478),
            new Tile(2879, 3478),
            new Tile(2878, 3478),
            new Tile(2877, 3478),
            new Tile(2876, 3478),
            new Tile(2875, 3478),
            new Tile(2874, 3479),
            new Tile(2873, 3480)
    });

    private final Tile[] path;

    Path(Tile[] path) {
        this.path = path;
    }

    public Tile[] getPath() {
        return this.path;
    }

}
