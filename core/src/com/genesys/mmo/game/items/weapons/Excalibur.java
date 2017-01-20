package com.genesys.mmo.game.items.weapons;

import com.genesys.mmo.game.items.Weapon;

/**
 * Created by brendan on 1/19/17.
 */
public class Excalibur extends Weapon {

    private static final String NAME = "Excalibur";
    private static final String DESCRIPTION = "A sword handed down for generations, said to be created by God himself.";
    private static final int VALUE = 1000000;
    private static final boolean TRADEABLE = true;
    private static final Weapon.Type TYPE = Type.MELEE;
    private static final double BASE_DAMAGE = 1000.0;
    private static final double CRITICAL_HIT_RATIO = 0.25;
    private static final double ACCURACY = 0.75;

    public Excalibur() {
        super(NAME, DESCRIPTION, VALUE, TRADEABLE, TYPE, BASE_DAMAGE, CRITICAL_HIT_RATIO, ACCURACY);
    }
}
