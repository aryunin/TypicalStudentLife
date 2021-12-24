package View.GUI;

import Model.GUI.ExitButton;
import Model.GUI.PlayButton;
import View.Screens.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuGUI extends GUI {
    public MenuGUI(Viewport viewport) {
        super(viewport);

        Label title = new Label("Typical Student Life", new Skin(Gdx.files.internal("GUI.json")), "label");
        title.setPosition(MenuScreen.worldWidth / 2f-400f, MenuScreen.worldHeight / 2f + 175f);
        stage.addActor(title);

        final float buttonWidth = 400f;
        final float buttonHeight = 100f;
        PlayButton playButton = new PlayButton(MenuScreen.worldWidth / 2f - buttonWidth / 2f, MenuScreen.worldHeight / 2f - buttonHeight / 2f + 60f);
        playButton.setFontScale(0.8f);
        ExitButton exitButton = new ExitButton(MenuScreen.worldWidth / 2f - buttonWidth / 2f, MenuScreen.worldHeight / 2f - buttonHeight / 2f - 60f);
        exitButton.setFontScale(0.8f);
        stage.addActor(playButton);
        stage.addActor(exitButton);
    }
}
