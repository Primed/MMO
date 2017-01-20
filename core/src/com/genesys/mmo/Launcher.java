package com.genesys.mmo;

import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.Game;
import com.genesys.mmo.utils.Constants;

import java.util.Scanner;

public class Launcher extends com.badlogic.gdx.Game {

    private static Player player;

	public Launcher() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a username: ");
        final String username = input.nextLine();
        System.out.println("Welcome, " + username + "!");
        final int access = (username.equalsIgnoreCase(Constants.OWNER) ? Player.OWNER_ACCESS : Constants.DEFAULT_ACCESS_LEVEL);

        player = new Player(username, 0, 0, access);

        //world.addGameObject(player); // Adds our player to the world

        Thread commandThread = new Thread(() -> {
            boolean flag = true;
            do {
                System.out.print("Enter a command: ");
                String command = input.nextLine();
                Command.parseCommand(command);
            } while (flag);
            input.close();
        });

        commandThread.start();
    }

	@Override
	public void create () {
		setScreen(new Game());
	}

	@Override
	public void render() {
		super.render();
	}

    /* Getters and setters */

    public static Player getPlayer() {
        return player;
    }
}
