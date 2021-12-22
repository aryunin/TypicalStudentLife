package View.Screens;

import Model.GameObjects.Background;
import View.GUI.MenuGUI;
import View.GUI.GUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen implements Screen {
    static public final int worldWidth = 1024;
    static public final int worldHeight = 768;
    private Background background;
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private MenuGUI gui;

    @Override
    public void show() {
        background = new Background(0,0);
        camera = new OrthographicCamera();
        viewport = new FitViewport(worldWidth,worldHeight, camera);
        batch = new SpriteBatch();
        gui = new MenuGUI(viewport);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        batch.end();

        gui.update();
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
