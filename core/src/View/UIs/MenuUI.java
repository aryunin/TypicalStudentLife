package View.UIs;

import Tools.ScreenManager;
import View.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuUI extends UI {
    private TextButton playButton;
    private TextButton exitButton;

    public MenuUI(Viewport viewport) {
        super(viewport, new Skin(Gdx.files.internal("Gui.json")));

        playButton = new TextButton("Play",skin,"button");
        exitButton = new TextButton("Exit", skin, "button");
        final float buttonWidth = 400;
        final float buttonHeight = 100;

        playButton.getLabel().setFontScale(0.9f);
        playButton.setSize(buttonWidth,buttonHeight);
        playButton.setPosition(Gdx.graphics.getWidth() / 2f - buttonWidth / 2f, Gdx.graphics.getHeight() / 2f - buttonHeight / 2f + 60f);
        playButton.addListener(new InputListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                playButton.setChecked(true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                playButton.setChecked(false);
            }

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ScreenManager.setScreen(new GameScreen());
                return true;
            }
        });
        stage.addActor(playButton);

        exitButton.getLabel().setFontScale(0.9f);
        exitButton.setSize(buttonWidth,buttonHeight);
        exitButton.setPosition(Gdx.graphics.getWidth() / 2f - buttonWidth / 2f, Gdx.graphics.getHeight() / 2f - buttonHeight / 2f- 60f);
        exitButton.addListener(new InputListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                exitButton.setChecked(true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                exitButton.setChecked(false);
            }
        });
        stage.addActor(exitButton);
    }
}
