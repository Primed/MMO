package com.genesys.mmo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.utils.Log;

/**
 * Created by brendan on 1/7/17.
 */
public class Input implements InputProcessor {

    private Player player;

    public Input(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        Log.debug(this, "Key down");
        switch (keycode) {
            case com.badlogic.gdx.Input.Keys.UP:
                player.moveUp();
                break;
            case com.badlogic.gdx.Input.Keys.DOWN:
                player.moveDown();
                break;
            case com.badlogic.gdx.Input.Keys.LEFT:
                player.moveLeft();
                break;
            case com.badlogic.gdx.Input.Keys.RIGHT:
                player.moveRight();
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Log.debug(this, "Touch down");
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Log.debug(this, "Touch up");
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
