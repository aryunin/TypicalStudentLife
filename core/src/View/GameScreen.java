package View;

import Controller.InputHandler;
import Model.Background;
import Model.GameObject;
import Model.RecordBook;
import Tools.Factory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

import static com.artemiiik.tsl.Main.random;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Array<GameObject> objects;

    static public TextureAtlas atlas;
    static public float deltaCff;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        objects = new Array<>();
        // Add new objects here
        objects.add(new Background(0, 0));
        objects.add(new RecordBook(0, 0));
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        InputHandler.handleInput();

        Factory fallersFactory = Factory.getRandomFactory();
        float fallerPosX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
        float fallerPosY = Gdx.graphics.getHeight();
        objects.add(fallersFactory.create(fallerPosX, fallerPosY));

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
