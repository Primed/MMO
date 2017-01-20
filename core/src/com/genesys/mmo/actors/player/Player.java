package com.genesys.mmo.actors.player;

import com.genesys.mmo.actors.Actor;
import com.genesys.mmo.actors.CombatActor;
import com.genesys.mmo.actors.enemy.Enemy;
import com.genesys.mmo.game.Camera;
import com.genesys.mmo.game.Game;
import com.genesys.mmo.game.Skill;
import com.genesys.mmo.utils.Constants;

import java.util.ArrayList;

/**
 * Created by brendan on 1/7/17.
 */
public class Player extends CombatActor {

    public static final int OWNER_ACCESS = 0;
    public static final int ADMIN_ACCESS = 1;
    public static final int PLAYER_ACCESS = 2;

    private LevelUpListener levelUpListener;

    private Skill.LevelUpListener levelUpTemplate = new Skill.LevelUpListener(() -> {
        int newLevel = getLevel();
        if (newLevel != level) {
            level = newLevel;
            System.out.println("You just achieved level " + newLevel + "!");
            if (levelUpListener != null) {
                levelUpListener.onLevelUp();
            }
        }
    });

    public int access;

    /* Constructors */

    public Player(String name, int x, int y, int access) {
        super(name, x, y, Constants.PLAYER_COLOR);
        this.access = access;
        for (Skill skill : skills) {
            skill.setLevelUpListener(levelUpTemplate);
        }
    }

    /* Instance methods */

    public void addExperience(int skillID, int experience) {
        skills.get(skillID).addExperience(experience);
    }

    public void moveUp() {
        setY(getY() + 1);
    }

    public void moveDown() {
        setY(getY() - 1);
    }

    public void moveLeft() {
        setX(getX() - 1);
    }

    public void moveRight() {
        setX(getX() + 1);
    }

    public void awardXP(int amount) {
        // TODO: Convert XP from ints to doubles.
        int xp = Math.round(amount / 2); // Splits the xp between hitpoints and whatever skill the
        // player is currently using.
        addExperience(getSkillID("hitpoints"), xp);

        switch (getWeaponType()) {
            case MELEE:
                addExperience(getSkillID("attack"), xp);
                break;
            case MAGIC:
                addExperience(getSkillID("magic"), xp);
                break;
            case RANGED:
                addExperience(getSkillID("archery"), xp);
                break;
        }
    }

    /* Overridden parent methods */

    @Override
    public void onDeath(CombatActor dealer) {
        super.onDeath(dealer);
        System.out.println("You were killed by a " + dealer.getName());
    }

    /* Getters */

    public int getAccess() {
        return access;
    }

    /* Setters */

    @Override
    public void setX(int x) {
        this.name = name;
        super.setX(x);
        Camera camera = Game.getCamera();
        if (camera != null) {
            camera.setX(x);
        }
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        Camera camera = Game.getCamera();
        if (camera != null) {
            camera.setY(y);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
        Camera camera = Game.getCamera();
        if (camera != null) {
            camera.setPosition(x, y);
        }
    }

    /* Instance classes */

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
