package com.genesys.mmo.actors.enemy;

import com.badlogic.gdx.graphics.Color;
import com.genesys.mmo.actors.Actor;
import com.genesys.mmo.actors.CombatActor;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.Skill;
import com.genesys.mmo.game.combat.Combat;

import java.util.List;

/**
 * Created by brendan on 1/19/17.
 */
public class Enemy extends CombatActor {

    private String description;
    private double xp;

    /* Constructors */

    public Enemy(String name, String description, double xp, Color color, int x, int y, int... skills) {
        super(name, x, y, color);
        this.description = description;
        this.xp = xp;
        setSkills(skills);
    }

    /* Overridden parent methods */

    @Override
    public void onDeath(CombatActor dealer) {
        super.onDeath(dealer);
        if (dealer instanceof Player) {
            ((Player) dealer).awardXP((int) getXp());
        }
        System.out.println("You have defeated a " + name + "!");
    }

    /* Instance methods */

    public void setSkills(int... levels) {
        if (levels.length == skills.size()) {
            for (int i = 0; i < levels.length; i++) {
                skills.get(i).setLevel(level);
            }
        }
    }

    /* Getters and Setters */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }
}
