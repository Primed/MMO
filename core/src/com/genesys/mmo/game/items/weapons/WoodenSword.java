package com.genesys.mmo.game.items.weapons;

import com.genesys.mmo.game.items.Weapon;

/**
 * Created by brendan on 1/17/17.
 */
public class WoodenSword extends Weapon {

    private static final String NAME = "Wooden Sword";
    private static final String DESCRIPTION = "A sword carved from normal wood, often used for training attack.";
    private static final int VALUE = 20;
    private static final boolean TRADEABLE = true;
    private static final Type TYPE = Type.MELEE;
    private static final double BASE_DAMAGE = 20.0;
    private static final double CRITICAL_HIT_RATIO = 0.05;
    private static final double ACCURACY = 0.85;

    public WoodenSword() {
        super(NAME, DESCRIPTION, VALUE, TRADEABLE, TYPE, BASE_DAMAGE, CRITICAL_HIT_RATIO, ACCURACY);
    }
}
