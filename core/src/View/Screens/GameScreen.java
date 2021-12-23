package View.Screens;

import Controller.InputHandler;
import Model.GameObjects.*;
import Tools.Collision;
import Tools.FallersFactory;
import Tools.ScreenManager;
import View.GUI.GameGUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.artemiiik.tsl.TSL.random;

public class GameScreen implements Screen {
    static public final float worldWidth = 1024f;
    static public final float worldHeight = 768f;
    static public float deltaCff = 0;
    private Background background;
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private GameGUI gui;
    private RecordBook recordBook;
    private Array<GameObject> fallers;
    private float fallFrequency;

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    private void updateObjects() {
        recordBook.update();
        for (GameObject object : fallers)
            object.update();
    }

    private void drawObjects() {
        batch.begin();
        background.draw(batch);
        recordBook.draw(batch);
        for (GameObject object : fallers)
            object.draw(batch);
        batch.end();
    }

    private float fallTimer;
    private void createFallers() {
        fallTimer -= deltaCff;
        if(fallTimer <= 0) {
            FallersFactory fallersFactory = FallersFactory.getRandomFactory();
            float posX = getRandomFloat(0f, worldWidth-100f);
            fallers.add(fallersFactory.create(posX,worldHeight));
            fallTimer = 1/fallFrequency;
        }
    }

    private void checkCollision() {
        int index = Collision.check(recordBook, fallers);
        GameObject collisionObject;
        if (index != -1) {
            collisionObject = fallers.get(index);
            if(collisionObject.getClass() == Book.class) {
                gui.score.add(1);
                fallFrequency += 0.05f;
                fallers.removeIndex(index);
            }
            if(collisionObject.getClass() == Bottle.class) {
                gui.mark.add(-1);
                fallers.removeIndex(index);
            }
        }

        for (int i = 0; i < fallers.size; i++) {
            collisionObject = fallers.get(i);
            if(collisionObject.getBounds().getY() < -100f) {
                if (collisionObject.getClass() == Book.class)
                    gui.mark.add(-1);
                fallers.removeIndex(i);
            }
        }
    }

    @Override
    public void show() {
        background = new Background(0f,0f);
        camera = new OrthographicCamera();
        viewport = new FitViewport(worldWidth,worldHeight,camera);
        batch = new SpriteBatch();
        gui = new GameGUI(viewport);
        recordBook = new RecordBook(0f,0f);
        fallers = new Array<>();
        fallFrequency = 0.5f;
        fallTimer = fallFrequency;
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        createFallers();

        InputHandler.handleInput();

        updateObjects();
        gui.update();
        checkCollision();

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        drawObjects();
        gui.draw();

        if(gui.mark.getCount() <= 2) ScreenManager.setScreen(new EndScreen(gui.score.getCount()));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
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
        gui.dispose();
        batch.dispose();
    }
}
