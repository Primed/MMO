package com.genesys.mmo.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.enemy.Goblin;
import com.genesys.mmo.actors.enemy.PracticeDummy;
import com.genesys.mmo.world.World;

/**
 * Created by brendan on 1/7/17.
 */
public class GameObject {

    private Vector2 position = new Vector2();
    private Color color;

    /* Constructors */

    public GameObject(int x, int y, Color color) {
        setPosition(x, y);
        this.color = color;
        World.addGameObject(this);
    }

    /* Instance methods */

    public void remove() {
        World.removeGameObject(this);
    }

    public static GameObject create(int id, int x, int y) {
        GameObject gameObject = null;
        switch (id) {
            case 0:
                gameObject = new PracticeDummy(x, y);
                break;
            case 1:
                gameObject = new Goblin(x, y);
                break;
        }
        return gameObject;
    }

    /* Getters and setters */

    public void setPosition(int x, int y) {
        position = new Vector2(x, y);
    }

    public void setX(int x) {
        position.x = x;
    }

    public void setY(int y) {
        position.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getX() {
        return (int) position.x;
    }

    public int getY() {
        return (int) position.y;
    }
}
