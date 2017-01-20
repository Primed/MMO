package com.genesys.mmo.game.items.weapons;

import com.genesys.mmo.game.items.Weapon;

/**
 * Created by brendan on 1/17/17.
 */
public class WoodenStaff extends Weapon {

    private static final String NAME = "Wooden Staff";
    private static final String DESCRIPTION = "A staff made from the branch of a normal tree. It is typically used in practicing magic.";
    private static final int VALUE = 20;
    private static final boolean TRADEABLE = true;
    private static final Type TYPE = Type.MAGIC;
    private static final double BASE_DAMAGE = 20.0;
    private static final double CRITICAL_HIT_RATIO = 0.05;
    private static final double ACCURACY = 0.85;

    public WoodenStaff() {
        super(NAME, DESCRIPTION, VALUE, TRADEABLE, TYPE, BASE_DAMAGE, CRITICAL_HIT_RATIO, ACCURACY);
    }
}
