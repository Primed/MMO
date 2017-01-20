package com.genesys.mmo.game.items;

import com.genesys.mmo.game.items.weapons.WoodenSword;

/**
 * Created by brendan on 1/17/17.
 */
public class Item {

    private String name;
    private String description;
    private int value;
    private boolean tradeable;

    public Item(String name, String description, int value, boolean tradeable) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.tradeable = tradeable;
    }

    /* Getters and setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
