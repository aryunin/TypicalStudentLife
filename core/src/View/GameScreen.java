package View;

import Controller.InputHandler;
import Model.Background;
import Model.GameObject;
import Model.RecordBook;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {
    private TextureAtlas atlas;
    private SpriteBatch batch;
    private Array<GameObject> objects;
    static public float deltaCff;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        objects = new Array<>();
        // Add new objects here
        objects.add(new Background(atlas, 0, 0));
        objects.add(new RecordBook(atlas, 0, 0));
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        InputHandler.handleInput();

        batch.begin();
        for (GameObject object : objects) {
            object.update();
            object.draw(batch);
        }
        batch.end();
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
        batch.dispose();
    }
}
