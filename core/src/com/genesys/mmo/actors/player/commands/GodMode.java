package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.actors.player.Command;

/**
 * Created by brendan on 1/22/17.
 */
public class GodMode extends Command {

    public static final String NAME = "godmode";
    public static final int ACCESS = Command.OWNER_COMMAND;

    public GodMode() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        System.out.println("God mode enabled!");
    }
}
