package com.genesys.mmo.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.genesys.mmo.Launcher;
import com.genesys.mmo.actors.GameObject;
import com.genesys.mmo.actors.player.Command;
import com.genesys.mmo.actors.player.Player;
import com.genesys.mmo.actors.player.commands.*;
import com.genesys.mmo.utils.Constants;
import com.genesys.mmo.utils.Log;
import com.genesys.mmo.world.World;

/**
 * Created by brendan on 1/6/17.
 */
public class Game implements Screen {

    public static final String[] SKILLS = { "Hitpoints", "Attack", "Defense", "Magic", "Archery", "Speed" };
    public static final Command[] COMMANDS = { new AddXP(), new Equip(), new GodMode(), new MaxSkills(), new SetLevel(),
            new SetXP(), new Spawn(), new Stats(), new TestCombat() };

    private static Camera camera;
    private static ShapeRenderer renderer;
    private final Color GRID_COLOR = new Color(1, 1, 1, 0.5f);
    private Player player;
    private Input input;

    /**
     * Called when this screen becomes the current screen for a Game.
     */
    @Override
    public void show() {
        Log.debug(this, "Game is now active.");

        renderer = new ShapeRenderer();
        camera = new Camera(renderer);
        player = Launcher.getPlayer();
        camera.setPosition(player.getPosition());

        input = new Input(player);
        Gdx.input.setInputProcessor(input);

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    /**
     * Called when the screen should render itself.
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        // Calls for a frame math update
        update(delta);

        // Do nothing if our renderer or camera isn't assigned.
        if (renderer == null || camera == null) return;

        clearScreen();

        renderer.setAutoShapeType(true);
        renderer.begin();

        if (Constants.SHOW_GRID_LINES) {
            drawGrid();
        }
        drawActors();
        //drawUI();

        renderer.end();
    }

    /**
     * Called when the screen changes dimensions.
     * @param width The new screen width.
     * @param height The new screen height.
     */
    @Override
    public void resize(int width, int height) {
        Log.debug(this, "Game window has been resized.");
    }

    /**
     * Called when the game enters a paused state.
     */
    @Override
    public void pause() {
        Log.debug(this, "Game paused.");
    }

    /**
     * Called when the game returns from a paused state.
     */
    @Override
    public void resume() {
        Log.debug(this, "Game unpaused.");
    }

    /**
     * Called when this screen is no longer the current screen for a Game.
     */
    @Override
    public void hide() {
        Log.debug(this, "Game hidden.");
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        Log.debug(this, "Game disposed.");
    }

    public static Camera getCamera() {
        return camera;
    }

    public static ShapeRenderer getRenderer() {
        return renderer;
    }

    private void update(float delta) {

    }

    private void clearScreen() {
        // Converts our background color (set in our constants class) to rgba format.
        float r = Constants.BACKGROUND_COLOR.r;
        float g = Constants.BACKGROUND_COLOR.g;
        float b = Constants.BACKGROUND_COLOR.b;
        float a = Constants.BACKGROUND_COLOR.a;

        // This clears the screen of the last render by painting over it with a solid color.
        Gdx.gl.glClearColor(r, g, b, a);
//       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT |
                GL20.GL_DEPTH_BUFFER_BIT |
                (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
    }

    private void drawGrid() {
        renderer.setColor(GRID_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Line);

        // Calculates our view bounds, so anything out of view of the camera gets culled.
        int minX = (int) Math.floor(camera.position.x - (camera.viewportWidth / 2));
        int maxX = (int) Math.ceil(camera.position.x + (camera.viewportWidth / 2));
        int minY = (int) Math.floor(camera.position.y - (camera.viewportHeight / 2));
        int maxY = (int) Math.ceil(camera.position.y + (camera.viewportHeight / 2));

        // Draws our vertical grid lines.
        for (int i = minX; i <= maxX; i++) {
            renderer.line(i, minY, i, maxY);
        }

        // Draws our horizontal grid lines.
        for (int i = minY; i <= maxY; i++) {
            renderer.line(minX, i, maxX, i);
        }
    }

    private void drawActors() {
        for (GameObject gameObject : World.getGameObjects()) {
            renderer.setColor(gameObject.getColor());
            renderer.set(ShapeRenderer.ShapeType.Filled);
            renderer.rect(gameObject.getX(), gameObject.getY(), 1, 1);
        }
    }

    private void drawUI() {
        renderer.setColor(Color.GREEN);
        Vector3 position = camera.unproject(new Vector3(0, Gdx.graphics.getHeight(), 0));
        renderer.rect(position.x, position.y, 2, 2);
    }
}
