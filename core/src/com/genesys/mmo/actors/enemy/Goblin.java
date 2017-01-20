package com.genesys.mmo.actors.enemy;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by brendan on 1/19/17.
 */
public class Goblin extends Enemy {

    private static final String NAME = "Goblin";
    private static final String DESCRIPTION = "A snarling beast with the intelligence level of a rock.";
    private static final double XP = 100;
    private static final Color COLOR = Color.GREEN;
    private static final int[] SKILLS = {
            2,  // Hitpoints
            3,  // Attack
            3,  // Defense
            1,  // Magic
            1,  // Archery
            2   // Speed
    };

    public Goblin(int x, int y) {
        super(NAME, DESCRIPTION, XP, COLOR, x, y, SKILLS);
    }
}
