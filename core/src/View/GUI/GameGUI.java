package View.GUI;

import Model.GUI.Counter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameGUI extends GUI {
    public Counter counter;

    public GameGUI(Viewport viewport) {
        super(viewport);
        counter = new Counter(0, 50f, Gdx.graphics.getHeight() - 100f, 0.8f);
        stage.addActor(counter);
    }
}
