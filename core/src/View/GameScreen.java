package View;

import Controller.InputHandler;
import Model.Actor;
import Model.GameObject;
import Model.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {
    private TextureAtlas atlas;
    private SpriteBatch batch;
    private Array<StaticObject> staticObjects;
    private Array<Actor> actors;
    private Array<GameObject> objects;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        staticObjects = new Array<>();
        // Add your static objects here
        actors = new Array<>();
        // Add your actors here
        objects = new Array<>();
        objects.addAll(staticObjects);
        objects.addAll(actors);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Control
        InputHandler.handleInput();
        for (Actor actor : actors) {
            actor.update(delta);
        }

        // Render
        batch.begin();
        for (GameObject object : objects) {
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
