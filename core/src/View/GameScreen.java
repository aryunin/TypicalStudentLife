package View;

import Controller.InputHandler;
import Model.Actor;
import Model.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import java.awt.geom.Point2D;

public class GameScreen implements Screen {
    private TextureAtlas atlas;
    private SpriteBatch batch;
    private Array<GameObject> objects;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        objects = new Array<>();
        // Add objects here
        objects.add(new Actor(atlas.findRegion("RecordBook"),0, 0, 80, 65,0));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for (GameObject object : objects) {
            object.update(delta);
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
