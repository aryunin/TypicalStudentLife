package View.UIs;

import Tools.ScreenManager;
import View.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuUI extends UI {
    private Button playButton;

    public MenuUI(Viewport viewport) {
        super(viewport, new Skin(Gdx.files.internal("glassy-ui.json")));

        playButton = new TextButton("Play",skin,"default");
        float playButtonWidth = 200;
        float playButtonHeight = 100;
        playButton.setSize(playButtonWidth,playButtonHeight);
        playButton.setPosition(Gdx.graphics.getWidth() / 2f - playButtonWidth / 2f, Gdx.graphics.getHeight() / 2f - playButtonHeight / 2f);
        stage.addActor(playButton);

        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ScreenManager.setScreen(new GameScreen());
                return true;
            }
        });
    }
}
