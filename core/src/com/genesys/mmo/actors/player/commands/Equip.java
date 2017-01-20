package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.game.items.Weapon;
import com.genesys.mmo.utils.Constants;

/**
 * Created by brendan on 1/22/17.
 */
public class Equip extends Command {

    public static final String NAME = "equip";
    public static final int ACCESS = Command.PLAYER_COMMAND;

    public Equip() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        if (arguments != null || arguments.length > 0) {
            try {
                int itemID = Integer.parseInt(arguments[0]);
                Weapon weapon = (Weapon) Constants.ITEMS[itemID];
                Launcher.getPlayer().setWeapon(weapon);
                System.out.println("Equipped " + weapon.getName().toLowerCase() + ".");
            } catch (Exception e) {
                System.out.println("Incorrect syntax.");
            }
        }
    }
}
