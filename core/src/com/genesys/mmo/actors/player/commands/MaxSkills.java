package com.genesys.mmo.actors.player.commands;

import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.game.Skill;

/**
 * Created by brendan on 1/22/17.
 */
public class MaxSkills extends Command {

    public static final String NAME = "maxskills";
    public static final int ACCESS = Command.ADMIN_COMMAND;

    public MaxSkills() {
        super(NAME, ACCESS);
    }

    @Override
    public void run(String... arguments) {
        for (Skill skill : Launcher.getPlayer().getSkills()) {
            skill.setLevel(99);
        }
    }
}
