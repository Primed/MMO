package com.genesys.mmo.utils;

import com.badlogic.gdx.graphics.Color;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.items.Item;
import com.genesys.mmo.game.items.weapons.Excalibur;
import com.genesys.mmo.game.items.weapons.WoodenBow;
import com.genesys.mmo.game.items.weapons.WoodenStaff;
import com.genesys.mmo.game.items.weapons.WoodenSword;

/**
 * Created by brendan on 1/6/17.
 */
public class Constants {

    public static final boolean SHOW_DEBUG_LOGS = false;
    public static final boolean SHOW_GRID_LINES = false;

    // How many pixels are in one game unit. (1280px = 25.6 units)
    public static final float VIEWPORT_RATIO = 50f;

    public static final Color BACKGROUND_COLOR = Color.valueOf("#546E7A");
    public static final Color PLAYER_COLOR = Color.WHITE;

    public static final String OWNER = "primed";
    // 0 = Owner, 1 = Admin, 2 = Player
    public static final int DEFAULT_ACCESS_LEVEL = Player.PLAYER_ACCESS;

    public static final Item[] ITEMS = {
            new Item(
                    "Test Item",
                    "This item is only used for debugging purposes.",
                    0,
                    false),
            new WoodenSword(),
            new WoodenStaff(),
            new WoodenBow(),
            new Excalibur()
    };

    public static final int MAX_LEVEL = 99;
    public static final int MIN_LEVEL = 1;

    public static final int UNARMED_DAMAGE = 10;
}
