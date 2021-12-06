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
    static public TextureAtlas atlas;
    static public float deltaCff;
    private SpriteBatch batch;
    private Map<String, Layer> layers;
    private CollisionChecker collision;
    private float fallDelay;
    private float fallTimer;

    public void setTextureAtlas(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    private void addLayer(String layerName) {
        layers.put(layerName, new Layer());
    }

    private void addObject(String layerName, GameObject object) {
        layers.get(layerName).objects.add(object);
    }

    private void createFaller() {
        Factory fallersFactory = Factory.getRandomFactory();
        float fallerPosX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
        float fallerPosY = Gdx.graphics.getHeight();
        addObject("CollisionLayer", fallersFactory.create(fallerPosX, fallerPosY));
    }

    @Override
    public void show() {
        deltaCff = 0;
        batch = new SpriteBatch();
        layers = new HashMap<>();
        addLayer("BackgroundLayer");
        addLayer("ActorsLayer");
        addLayer("CollisionLayer");
        collision = new CollisionChecker(layers.get("ActorsLayer").objects, layers.get("CollisionLayer").objects);
        fallDelay = 2f;
        fallTimer = fallDelay;

        addObject("BackgroundLayer", new Background(0, 0));
        addObject("ActorsLayer", new RecordBook(0, 0));
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
