package View.Screens;

import Controller.InputHandler;
import Tools.CollisionChecker;
import View.GameObjectsLayers.GameObjectsLayer;
import View.GameObjectsLayers.RBLayer;
import View.GameObjectsLayers.BackgroundLayer;
import View.GameObjectsLayers.FallersLayer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {
    static public TextureAtlas atlas;
    static public float deltaCff;
    private Game main;
    private SpriteBatch batch;
    private Array<GameObjectsLayer> layers;
    private CollisionChecker collisionChecker;
    private float fallDelay;
    private float fallTimer;

    public GameScreen(Game main) {
        this.main = main;
    }

    @Override
    public void show() {
        deltaCff = 0;
        batch = new SpriteBatch();
        fallDelay = 2f;
        fallTimer = fallDelay;

        layers = new Array<>();
        layers.add(new BackgroundLayer());
        layers.add(new RBLayer());
        layers.add(new FallersLayer());

        collisionChecker = new CollisionChecker(layers.get(1).objects,layers.get(2).objects);
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        collisionChecker.check();

        for (GameObjectsLayer layer : layers) {
            for (int i = 0; i < layer.objects.size; i++) {
                if (layer.objects.get(i).toDelete()) layer.objects.removeIndex(i);
            }
        }

        fallTimer -= delta;
        if(fallTimer <= 0) {
            ((FallersLayer)layers.get(2)).createRandomFaller();
            fallTimer = fallDelay;
        }

        InputHandler.handleInput();
        for(GameObjectsLayer layer : layers) layer.update();

        batch.begin();
        for(GameObjectsLayer layer : layers) layer.draw(batch);
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
