package com.genesys.mmo.game.items;

/**
 * Created by brendan on 1/17/17.
 */
public class Weapon extends Item {

    public enum Type {
        MELEE,
        RANGED,
        MAGIC
    }

    private Type type;

    private double baseDamage;

    private double criticalRatio;
    private double accuracy;

    public Weapon(String name, String description, int value, boolean tradeable, Type type, double baseDamage,
                  double criticalRatio, double accuracy) {
        super(name, description, value, tradeable);
        this.type = type;
        this.baseDamage = baseDamage;
        this.criticalRatio = criticalRatio;
        this.accuracy = accuracy;
    }

    /* Getters and Setters */

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getCriticalRatio() {
        return criticalRatio;
    }

    public void setCriticalRatio(double criticalRatio) {
        this.criticalRatio = criticalRatio;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
