package View;

import Controller.InputHandler;
import Model.Background;
import Model.GameObject;
import Model.Layer;
import Model.RecordBook;
import Tools.Collision;
import Tools.Factory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import static com.artemiiik.tsl.Main.random;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private float fallDelay;
    private float fallTimer;
    private Collision collision; // TODO
    static public TextureAtlas atlas;
    static public float deltaCff;

    /** Layers **/
    private Layer backgroundLayer;
    private Layer actorsLayer;
    private Layer collisionLayer;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    private void createFaller() {
        Factory fallersFactory = Factory.getRandomFactory();
        float fallerPosX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
        float fallerPosY = Gdx.graphics.getHeight();
        collisionLayer.objects.add(fallersFactory.create(fallerPosX, fallerPosY));
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        backgroundLayer = new Layer();
        actorsLayer = new Layer();
        collisionLayer = new Layer();
        collision = new Collision(actorsLayer.objects, collisionLayer.objects);
        fallDelay = 2f;
        fallTimer = fallDelay;
        backgroundLayer.objects.add(new Background(0, 0));
        actorsLayer.objects.add(new RecordBook(0, 0));
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        collision.check();

        fallTimer -= delta;
        if(fallTimer <= 0) {
            createFaller();
            fallTimer = fallDelay;
        }

        InputHandler.handleInput();
        backgroundLayer.update();
        actorsLayer.update();
        collisionLayer.update();

        batch.begin();
        backgroundLayer.draw(batch);
        actorsLayer.draw(batch);
        collisionLayer.draw(batch);
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
