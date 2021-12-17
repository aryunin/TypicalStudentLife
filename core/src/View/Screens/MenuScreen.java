package View.Screens;

import Model.GameObjects.Background;
import View.UIs.MenuUI;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MenuScreen implements Screen {
    static public TextureAtlas atlas;
    private SpriteBatch batch;
    private MenuUI ui;
    private Background background;

    @Override
    public void show() {
        batch = new SpriteBatch();
        ui = new MenuUI(this);
        background = new Background(0,0);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        ui.update();
        batch.begin();
        background.draw(batch);
        batch.end();
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

    }
}
