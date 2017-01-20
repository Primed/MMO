package com.genesys.mmo.actors.player;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.commands.Stats;
import com.genesys.mmo.game.Game;

import java.util.Arrays;

/**
 * Created by brendan on 1/19/17.
 */
public abstract class Command {

    public static final int OWNER_COMMAND = 0;
    public static final int ADMIN_COMMAND = 1;
    public static final int PLAYER_COMMAND = 2;

    private String name;
    private int access;

    public Command(String name, int access) {
        this.name = name;
        this.access = access;
    }

    public static void parseCommand(String command) {
        // Removes multiple spaces in between words and at the beginning and end of the string.
        command = command.replace("[ ]{2,", "").trim();
        if (command.isEmpty()) return;

        String[] arguments = null;
        String[] commands = command.split(" ");
        if (commands.length > 1) {
            arguments = Arrays.copyOfRange(commands, 1, commands.length);
        }

        execute(commands[0], arguments);
    }

    private static void execute(String commandName, String... arguments) {
        Player player = Launcher.getPlayer();
        if (player != null) {
            Command command = findCommand(commandName, player);
            if (command != null) {
                command.run(arguments);
            } else {
                System.out.println("Command not found.");
            }
        }
    }

    private static Command findCommand(String commandName, Player player) {
        for (Command command : Game.COMMANDS) {
            if (command.name.equalsIgnoreCase(commandName)
                    && command.access >= player.getAccess()) {

                return command;
            }
        }
        return null;
    }

    public abstract void run(String... arguments);
}
