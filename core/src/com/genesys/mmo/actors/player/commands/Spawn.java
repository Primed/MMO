package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.actors.GameObject;
import com.genesys.mmo.actors.player.Command;

/**
 * Created by brendan on 1/22/17.
 */
public class Spawn extends Command {

    public static final String NAME = "spawn";
    public static final int ACCESS = Command.ADMIN_COMMAND;

    public Spawn() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        if (arguments.length >= 3) {
            GameObject.create(Integer.parseInt(arguments[0]),
                    Integer.parseInt(arguments[1]),
                    Integer.parseInt(arguments[2]));
        } else {
            System.out.println("Invalid syntax.");
        }
    }
}
