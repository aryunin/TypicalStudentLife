package View.Screens;

import Model.GameObjects.Background;
import View.GUI.EndGUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class EndScreen implements Screen {
    static public final float worldWidth = 1024;
    static public final float worldHeight = 768;
    private Background background;
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private EndGUI gui;

    public EndScreen(long score) {
        camera = new OrthographicCamera();
        viewport = new FitViewport(worldWidth, worldHeight, camera);
        gui = new EndGUI(viewport, score);
    }

    @Override
    public void show() {
        background = new Background(0f,0f);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        gui.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        batch.end();
        gui.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        gui.dispose();
        batch.dispose();
    }
}
