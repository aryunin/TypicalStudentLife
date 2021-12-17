package View.UIs;

import Tools.ScreenManager;
import View.Screens.GameScreen;
import View.Screens.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuUI extends UI {
    private MenuScreen menu;
    private Button playButton;

    public MenuUI(MenuScreen callingScreen) {
        super(new ScreenViewport(), new Skin(Gdx.files.internal("glassy-ui.json")));
        this.menu = callingScreen;
        playButton = new TextButton("Play",skin,"default");
        float playButtonWidth = 200;
        float playButtonHeight = 100;
        playButton.setSize(playButtonWidth,playButtonHeight);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButtonWidth, Gdx.graphics.getHeight() / 2 - playButtonHeight);
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
