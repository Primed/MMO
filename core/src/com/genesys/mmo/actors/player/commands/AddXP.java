package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.Skill;

/**
 * Created by brendan on 1/22/17.
 */
public class AddXP extends Command {

    public static final String NAME = "addxp";
    public static final int ACCESS = Command.ADMIN_COMMAND;

    public AddXP() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        if (arguments != null || arguments.length > 1) {
            Player player = Launcher.getPlayer();
            try {
                Skill skill;
                try {
                    int skillID = Integer.parseInt(arguments[0]);
                    skill = player.getSkill(skillID);
                } catch (Exception e) {
                    String skillName = arguments[0];
                    skill = player.getSkill(skillName);
                }
                int experience = Integer.parseInt(arguments[1]);
                System.out.println(experience + " experience points added to " + skill.getName() + ".");
                System.out.println("Total experience is now " + (skill.getExperience() + experience));
                skill.addExperience(experience);
            } catch (Exception e) {
                System.out.println("Incorrect syntax.");
            }
        }
    }
}
