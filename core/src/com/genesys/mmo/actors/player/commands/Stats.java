package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.Skill;

/**
 * Created by brendan on 1/19/17.
 */
public class Stats extends Command {

    public static final String NAME = "stats";
    public static final int ACCESS = Command.PLAYER_COMMAND;

    public Stats() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        Player player = Launcher.getPlayer();
        System.out.println("Username: " + player.getName());
        System.out.println("Access level: " + player.getAccess());
        System.out.println("X: " + player.getPosition().x + " Y: " + player.getPosition().y);
        System.out.println("Total level: " + player.getLevel());
        if (!player.isUnarmed()) {
            System.out.println("Weapon: " + player.getWeapon().getName());
        }
        System.out.println("Skills:");
        for (Skill skill : player.getSkills()) {
            String name = skill.getName();
            System.out.println("\t" + name + " experience: " + skill.getExperience() +
                    ", " + name + " level: " + skill.getLevel());
        }
    }
}
