package View.GUI;

import Model.GUI.Counter;
import View.Screens.GameScreen;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameGUI extends GUI {
    public Counter score;
    public Counter mark;

    public GameGUI(Viewport viewport) {
        super(viewport);
        score = new Counter("Score: ",0, 50f, GameScreen.worldHeight - 150f, 0.6f);
        mark = new Counter("Mark: ", 5, GameScreen.worldWidth - 275f, GameScreen.worldHeight - 150f, 0.6f);
        stage.addActor(score);
        stage.addActor(mark);
    }
}
