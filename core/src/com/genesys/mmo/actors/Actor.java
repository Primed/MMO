package com.genesys.mmo.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.genesys.mmo.game.Skill;

import java.util.List;

/**
 * Created by brendan on 1/7/17.
 */
public class Actor extends GameObject {

    protected String name;

    /* Constructors */

    public Actor(String name, int x, int y, Color color) {
        super(x, y, color);
        this.name = name;
    }

    /* Getters */

    public String getName() {
        return name;
    }

}
