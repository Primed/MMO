package com.genesys.mmo.actors;

import com.badlogic.gdx.graphics.Color;
import com.genesys.mmo.game.Game;
import com.genesys.mmo.game.Skill;
import com.genesys.mmo.game.combat.Combat;
import com.genesys.mmo.game.items.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brendan on 1/19/17.
 */
public class CombatActor extends Actor {

    public enum State {
        ALIVE,
        DEAD,
    }

    /**
     * This value should never be manipulated manually; rather, it's value is updated
     * when the user gains appropriate experience in enough other skills.
     */
    protected int level;
    private int hitpoints;
    private State state;

    /**
     * The skills and associated experience points of the current actor.
     */
    protected List<Skill> skills = new ArrayList<>();

    private Weapon weapon;

    /* Constructors */

    public CombatActor(String name, int x, int y, Color color) {
        super(name, x, y, color);
        for (String skillName : Game.SKILLS) {
            skills.add(new Skill(skillName));
        }
        setup();
    }

    public CombatActor(String name, int x, int y, Color color, Skill[] skills) {
        super(name, x, y, color);
        if (skills.length == Game.SKILLS.length) {
            for (Skill skill : skills) {
                this.skills.add(skill);
            }
        }
        setup();
    }

    public void setup() {
        level = getLevel();
        hitpoints = getMaxHitpoints();
        state = State.ALIVE;
    }

    /* Instance methods */

    public void attack(CombatActor target) {
        Combat.attack(this, target);
    }

    public void receiveDamage(CombatActor dealer, int amount) {
        hitpoints -= amount;
        if (hitpoints <= 0) {
            onDeath(dealer);
        }
    }

    public void onDeath(CombatActor dealer) {
        state = State.DEAD;
        remove();
    }

    /* Getters */

    /**
     * Calculates actor level.
     *
     * @return The level of the actor; generated simply by taking the average of all of the other skills.
     */
    public int getLevel() {
        double skillTotal = 0;

        for (Skill skill : skills) {
            skillTotal += skill.getLevel();
        }

        return (int) Math.floor(skillTotal / (double) skills.size());
    }

    public Skill getSkill(int skillID) {
        return skills.get(skillID);
    }

    public Skill getSkill(String name) {
        return getSkill(getSkillID(name));
    }

    public int getSkillID(String name) {
        if (name.equalsIgnoreCase("hitpoints")) {
            return 0;
        } else if (name.equalsIgnoreCase("attack")) {
            return 1;
        } else if (name.equalsIgnoreCase("defense")) {
            return 2;
        } else if (name.equalsIgnoreCase("magic")) {
            return 3;
        } else if (name.equalsIgnoreCase("archery")) {
            return 4;
        } else if (name.equalsIgnoreCase("speed")) {
            return 5;
        } else { // If input doesn't match a known skill, this statement is run.
            return -1;
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public int getMaxHitpoints() {
        return getSkill("hitpoints").getLevel() * 100;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isUnarmed() {
        return weapon == null;
    }

    public boolean isAlive() {
        return state == State.ALIVE;
    }

    public boolean isDead() {
        return state == State.DEAD;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public Weapon.Type getWeaponType() {
        if (!isUnarmed()) {
            switch (weapon.getType()) {
                case MELEE:
                    return Weapon.Type.MELEE;
                case MAGIC:
                    return Weapon.Type.MAGIC;
                case RANGED:
                    return Weapon.Type.RANGED;
            }
        }
        // If the player is unarmed, or for some reason the switch doesn't catch the type, we return melee.
        return Weapon.Type.MELEE;
    }

    /* Setters */

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        level = getLevel();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
}
