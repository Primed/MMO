package com.genesys.mmo.actors.enemy;

import com.badlogic.gdx.graphics.Color;
import com.genesys.mmo.game.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brendan on 1/17/17.
 */
public class PracticeDummy extends Enemy {

    private static final String NAME = "Practice Dummy";
    private static final String DESCRIPTION = "A cloth dummy used for honing combat skills.";
    private static final double XP = 50;
    private static final Color COLOR = Color.RED;
    private static final int[] SKILLS = {
            1,  // Hitpoints
            1,  // Attack
            1,  // Defense
            1,  // Magic
            1,  // Archery
            1   // Speed
    };

    public PracticeDummy(int x, int y) {
        super(NAME, DESCRIPTION, XP, COLOR, x, y, SKILLS);
    }
}
