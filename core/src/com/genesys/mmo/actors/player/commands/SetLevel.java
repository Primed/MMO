package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.Skill;

/**
 * Created by brendan on 1/19/17.
 */
public class SetLevel extends Command {

    public static final String NAME = "setlevel";
    public static final int ACCESS = Command.ADMIN_COMMAND;

    public SetLevel() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        Player player = Launcher.getPlayer();
        if (arguments != null || arguments.length > 1) {
            try {
                Skill skill;
                try {
                    int skillID = Integer.parseInt(arguments[0]);
                    skill = player.getSkill(skillID);
                } catch (Exception e) {
                    String skillName = arguments[0];
                    skill = player.getSkill(skillName);
                }
                int level = Integer.parseInt(arguments[1]);
                skill.setLevel(level);
            } catch (Exception e) {
                System.out.println("Incorrect syntax.");
            }
        }
    }
}
