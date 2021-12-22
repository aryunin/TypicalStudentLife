package View.GUI;

import Model.GUI.Counter;
import View.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameGUI extends GUI {
    public Counter score;
    public Counter mark;

    public GameGUI(Viewport viewport) {
        super(viewport);
        score = new Counter(0, 50f, GameScreen.worldHeight - 100f, 0.8f);
        mark = new Counter(5, GameScreen.worldWidth - 50f, Gdx.graphics.getHeight() - 100f, 0.8f);
        stage.addActor(score);
        stage.addActor(mark);
    }
}
