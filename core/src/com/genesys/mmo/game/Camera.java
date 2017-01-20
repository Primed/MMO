package com.genesys.mmo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.genesys.mmo.utils.Constants;

/**
 * Created by brendan on 1/7/17.
 */
public class Camera extends OrthographicCamera {

    private ShapeRenderer renderer;

    public Camera(ShapeRenderer renderer) {
        super(Gdx.graphics.getWidth() / Constants.VIEWPORT_RATIO,
                Gdx.graphics.getHeight() / Constants.VIEWPORT_RATIO);
        this.renderer = renderer;
        renderer.setProjectionMatrix(combined);
    }

    public void setPosition(Vector2 position) {
        setPosition(position.x, position.y);
    }

    public void setPosition(float x, float y) {
        position.x = x + 0.5f;
        position.y = y + 0.5f;
        update();
    }

    public void setX(float x) {
        position.x = x + 0.5f;
        update();
    }

    public void setY(float y) {
        position.y = y + 0.5f;
        update();
    }

    @Override
    public void update() {
        super.update();
        if (renderer != null) {
            renderer.setProjectionMatrix(combined);
        }
    }
}
