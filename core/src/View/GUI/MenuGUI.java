package View.GUI;

import Model.GUI.ExitButton;
import Model.GUI.PlayButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuGUI extends GUI {
    public MenuGUI(Viewport viewport) {
        super(viewport);
        stage.addActor(new PlayButton(Gdx.graphics.getWidth() / 2f - 400f / 2f, Gdx.graphics.getHeight() / 2f - 100f / 2f + 60f));
        stage.addActor(new ExitButton(Gdx.graphics.getWidth() / 2f - 400f / 2f, Gdx.graphics.getHeight() / 2f - 100f / 2f - 60f));
    }
}
