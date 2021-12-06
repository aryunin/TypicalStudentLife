package View;

import Controller.InputHandler;
import Model.Background;
import Model.GameObject;
import Model.Layer;
import Model.RecordBook;
import Tools.CollisionChecker;
import Tools.Factory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;
import java.util.Map;

import static com.artemiiik.tsl.Main.random;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private float fallDelay;
    private float fallTimer;
    private CollisionChecker collision; // TODO
    static public TextureAtlas atlas;
    static public float deltaCff;

    /** Layers **/
    private Map<String, Layer> layers;
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
        layers.get("CollisionLayer").objects.add(fallersFactory.create(fallerPosX, fallerPosY));
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        layers = new HashMap<>();
        layers.put("BackgroundLayer", new Layer());
        layers.put("ActorsLayer", new Layer());
        layers.put("CollisionLayer", new Layer());
        collision = new CollisionChecker(layers.get("ActorsLayer").objects, layers.get("CollisionLayer").objects);
        fallDelay = 2f;
        fallTimer = fallDelay;
        layers.get("BackgroundLayer").objects.add(new Background(0, 0));
        layers.get("ActorsLayer").objects.add(new RecordBook(0, 0));
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        collision.check();

        for (int i = 0; i < layers.get("CollisionLayer").objects.size; i++) {
            if (layers.get("CollisionLayer").objects.get(i).isDeleted())
                layers.get("CollisionLayer").objects.removeIndex(i);
        }

        fallTimer -= delta;
        if(fallTimer <= 0) {
            createFaller();
            fallTimer = fallDelay;
        }

        InputHandler.handleInput();
        for(Map.Entry<String,Layer> entry : layers.entrySet()) {
            entry.getValue().update();
        }

        batch.begin();
        for(Map.Entry<String,Layer> entry : layers.entrySet()) {
            entry.getValue().draw(batch);
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
