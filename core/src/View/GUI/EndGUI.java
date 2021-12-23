package View.GUI;

import Model.GUI.ExitButton;
import Model.GUI.PlayButton;
import View.Screens.EndScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class EndGUI extends GUI{
    public EndGUI(Viewport viewport, long score) {
        super(viewport);

        Label scoreLabel = new Label("Your score: " + score, new Skin(Gdx.files.internal("GUI.json")), "label");
        scoreLabel.setPosition(EndScreen.worldWidth / 2f-220f, EndScreen.worldHeight / 2f + 175f);
        scoreLabel.setFontScale(0.8f);
        stage.addActor(scoreLabel);

        final float buttonWidth = 400f;
        final float buttonHeight = 100f;
        PlayButton playButton = new PlayButton(EndScreen.worldWidth / 2f - buttonWidth / 2f, EndScreen.worldHeight / 2f - buttonHeight / 2f + 60f);
        playButton.setFontScale(0.8f);
        ExitButton exitButton = new ExitButton(EndScreen.worldWidth / 2f - buttonWidth / 2f, EndScreen.worldHeight / 2f - buttonHeight / 2f - 60f);
        exitButton.setFontScale(0.8f);
        stage.addActor(playButton);
        stage.addActor(exitButton);
    }
}
