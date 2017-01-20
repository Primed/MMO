package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.GameObject;
import com.genesys.mmo.actors.enemy.Enemy;
import com.genesys.mmo.actors.enemy.PracticeDummy;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;

/**
 * Created by brendan on 1/22/17.
 */
public class TestCombat extends Command {

    public static final String NAME = "testcombat";
    public static final int ACCESS = Command.OWNER_COMMAND;

    public TestCombat() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        if (arguments.length >= 1) {
            Player player = Launcher.getPlayer();
            Enemy enemy = (Enemy) GameObject.create(Integer.parseInt(arguments[0]), 1, 0);
            if (enemy != null) {
                int numHits = 0;
                while (enemy.isAlive()) {
                    player.attack(enemy);
                    numHits++;
                }
                System.out.println("It took " + numHits + " hits to kill the " + enemy.getName());
            } else {
                System.out.println("No enemy found.");
            }
        } else {
            System.out.println("Invalid syntax.");
        }
    }
}
