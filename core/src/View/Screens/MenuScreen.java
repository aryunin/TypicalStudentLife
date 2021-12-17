package View.Screens;

import Model.GameObjects.Background;
import View.UIs.MenuUI;
import View.UIs.UI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen implements Screen {
    private Camera camera;
    private Background background;
    private Viewport viewport;
    private SpriteBatch batch;
    private UI ui;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        background = new Background(0,0);
        float bgWidth = background.getBounds().getVertices()[2];
        float bgHeight = background.getBounds().getVertices()[7];
        viewport = new FitViewport(bgWidth,bgHeight,camera);
        batch = new SpriteBatch();
        ui = new MenuUI(viewport);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();
        background.draw(batch);
        batch.end();

        ui.update();
        ui.draw();
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
        ui.dispose();
        batch.dispose();
    }
}
