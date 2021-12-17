package View.Screens;

import Model.GameObjects.Background;
import View.UIs.MenuUI;
import View.UIs.UI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen {
    private SpriteBatch batch;
    private Background background;
    private UI ui;

    @Override
    public void show() {
        batch = new SpriteBatch();
        background = new Background(0,0);
        ui = new MenuUI();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        batch.end();

        ui.update();
        ui.draw();
    }

    @Override
    public void resize(int width, int height) {

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
