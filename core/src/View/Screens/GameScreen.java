package View.Screens;

import Controller.InputHandler;
import Model.GameObjects.Background;
import Model.GameObjects.GameObject;
import Model.GameObjects.RecordBook;
import Tools.CollisionChecker;
import Tools.FallersFactory;
import View.GUI.GameGUI;
import View.GUI.GUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.artemiiik.tsl.Main.random;

public class GameScreen implements Screen {
    private Background background;
    private Camera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private GUI gui;
    private RecordBook recordBook;
    private Array<GameObject> fallers;
    private float fallDelay;
    private float fallTimer;

    static public float deltaCff = 0;

    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    private void updateObjects() {
        recordBook.update();
        for (GameObject object : fallers) {
            object.update();
        }
    }

    private void drawObjects() {
        batch.begin();
        background.draw(batch);
        recordBook.draw(batch);
        for (GameObject object : fallers) {
            object.draw(batch);
        }
        batch.end();
    }

    private void deleteGarbage() {
        for (int i = 0; i < fallers.size; i++) {
            if (fallers.get(i).isDeleted()) fallers.removeIndex(i);
        }
    }

    private void createFallers() {
        fallTimer -= deltaCff;
        if(fallTimer <= 0) {
            FallersFactory fallersFactory = FallersFactory.getRandomFactory();
            float posX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
            float posY = Gdx.graphics.getHeight();
            fallers.add(fallersFactory.create(posX,posY));
            fallTimer = fallDelay;
        }
    }

    @Override
    public void show() {
        background = new Background(0,0);
        camera = new OrthographicCamera();
        float bgWidth = background.getBounds().getVertices()[2];
        float bgHeight = background.getBounds().getVertices()[7];
        viewport = new FitViewport(bgWidth,bgHeight,camera);
        batch = new SpriteBatch();
        gui = new GameGUI(viewport);
        recordBook = new RecordBook(0,0);
        fallers = new Array<>();
        fallDelay = 2f;
        fallTimer = fallDelay;
    }

    @Override
    public void render(float delta) {
        deltaCff = delta;
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deleteGarbage();
        createFallers();

        InputHandler.handleInput();
        updateObjects();
        drawObjects();

        CollisionChecker.check(recordBook, fallers);
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
