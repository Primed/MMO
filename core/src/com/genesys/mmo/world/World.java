package com.genesys.mmo.world;

import com.genesys.mmo.actors.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brendan on 1/7/17.
 */
public class World {

    private static final List<GameObject> gameObjects = new ArrayList<GameObject>();

    public static void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public static void removeGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
