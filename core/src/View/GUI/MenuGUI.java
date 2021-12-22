package View.GUI;

import Model.GUI.ExitButton;
import Model.GUI.PlayButton;
import View.Screens.MenuScreen;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuGUI extends GUI {
    public MenuGUI(Viewport viewport) {
        super(viewport);
        stage.addActor(new PlayButton(MenuScreen.worldWidth / 2f - 400f / 2f, MenuScreen.worldHeight / 2f - 100f / 2f + 60f));
        stage.addActor(new ExitButton(MenuScreen.worldWidth / 2f - 400f / 2f, MenuScreen.worldHeight / 2f - 100f / 2f - 60f));
    }
}
