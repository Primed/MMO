package com.genesys.mmo.game.combat;

import com.genesys.mmo.actors.CombatActor;
import com.genesys.mmo.actors.enemy.Enemy;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.game.items.Weapon;
import com.genesys.mmo.utils.Constants;

import static com.genesys.mmo.game.items.Weapon.Type.MAGIC;
import static com.genesys.mmo.game.items.Weapon.Type.MELEE;
import static com.genesys.mmo.game.items.Weapon.Type.RANGED;

/**
 * Created by brendan on 1/21/17.
 */
public class Combat {

    public static void attack(CombatActor dealer, CombatActor target) {
        int damage = getDamage(dealer, target);
        target.receiveDamage(dealer, damage);
        System.out.println(damage + " damage dealt to " + target.getName() + ".");
    }

    private static int getDamage(CombatActor dealer, CombatActor target) {
        double multiplier = Math.random(); // Get a random number from
        double targetDefense = (double) target.getSkill("defense").getLevel();
        double baseDamage = Constants.UNARMED_DAMAGE;
        double accuracy = 0.6;
        double critical = 0.0;

        double level = (double) dealer.getSkill("attack").getLevel(); // The default level is attack
        switch (dealer.getWeaponType()) { // If weapon type isn't melee, we change the default level here.
            case MAGIC:
                level = (double) dealer.getSkill("magic").getLevel();
                break;
            case RANGED:
                level = (double) dealer.getSkill("archery").getLevel();
                break;
            case MELEE:
                level = (double) dealer.getSkill("attack").getLevel();
        }

        if (!dealer.isUnarmed()) {
            Weapon weapon = dealer.getWeapon();
            baseDamage = weapon.getBaseDamage();
            accuracy = weapon.getAccuracy();
            critical = weapon.getCriticalRatio();
        }

        if (missed(accuracy)) {
            System.out.println("You missed.");
            return 0;
        }

        if (critical(critical)) {
            System.out.println("Critical hit!");
            multiplier *= 1.5;
        }

        return (int) Math.round(multiplier * getLevelDifferenceMultiplier(level, targetDefense) * baseDamage);
    }

    private static double getLevelDifferenceMultiplier(double playerAttack, double targetDefense) {
        double deltaLevel = playerAttack - targetDefense;
        if (deltaLevel > 0) {
            double constant = 0.4040610178;
            return (constant * Math.sqrt(deltaLevel)) + 1;
        } else if (deltaLevel < 0) {
            double constant = -0.067343503;
            return (constant * Math.sqrt(-deltaLevel)) + 1;
        } else {
            return 1.0;
        }
    }

    private static boolean missed(double accuracy) {
        return (Math.random() > accuracy);
    }

    private static boolean critical(double critical) {
        return (Math.random() <= critical);
    }
}
