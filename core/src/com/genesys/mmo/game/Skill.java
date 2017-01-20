package com.genesys.mmo.game;

import com.genesys.mmo.utils.Constants;
import com.genesys.mmo.utils.Utils;

/**
 * Created by brendan on 1/7/17.
 */
public class Skill {

    private String name;
    private int experience;
    private int level;
    private LevelUpListener levelUpListener;

    /**
     * Constructors
     */

    public Skill(String name) {
        this(name, 0);
    }

    public Skill(String name, LevelUpListener levelUpListener) {
        this(name);
        this.levelUpListener = levelUpListener;
    }

    public Skill(String name, int experience) {
        this.name = name;
        this.experience = experience;
        this.level = experienceToLevel(this.experience);
    }

    /**
     * Instance methods
     */

    public static int levelToExperience(int level) {
        return (int) Math.floor(((double) ((level * level) + level) / 2d) * 100d) - (level * 100);
    }

    public static int experienceToLevel(int experience) {
        return Utils.clamp((int) Math.floor((Math.sqrt(100 * (2 * experience + 25)) + 50d) / 100d),
                Constants.MIN_LEVEL,
                Constants.MAX_LEVEL);
    }

    public void addExperience(int experience) {
        this.experience += experience;
        onExperienceChanged(this.experience);
    }

    private void onExperienceChanged(int newExperience) {
        int newLevel = experienceToLevel(newExperience);
        onLevelChanged(newLevel);
    }

    private void onLevelChanged(int newLevel) {
        if (newLevel != level) { // If the level increases, these events are triggered:
            level = newLevel; // Update our level variable's value.
            System.out.println("Your " + name + " level is now " + newLevel + "!");
            if (levelUpListener != null) {
                levelUpListener.onLevelUp(); // And trigger our listener.
            }
        }
    }

    /**
     * Getters
     */

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    /**
     * Setters
     */

    public void setLevel(int level) {
        level = Utils.clamp(level, Constants.MIN_LEVEL, Constants.MAX_LEVEL);
        this.experience = levelToExperience(level);
        onLevelChanged(level);
    }

    public void setExperience(int experience) {
        this.experience = experience;
        onExperienceChanged(experience);
    }

    public void setLevelUpListener(LevelUpListener levelUpListener) {
        this.levelUpListener = levelUpListener;
    }

    /**
     * Instance classes
     */

    public static class LevelUpListener {

        private Runnable action;

        public LevelUpListener(Runnable action) {
            this.action = action;
        }

        public void onLevelUp() {
            action.run();
        }
    }
}
