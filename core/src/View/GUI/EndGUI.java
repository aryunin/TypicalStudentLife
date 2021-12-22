package View.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class EndGUI extends GUI{

    private MenuGUI menuGUI;

    public EndGUI(Viewport viewport, long score) {
        super(viewport);
        Label scoreLabel = new Label(String.valueOf(score), new Skin(Gdx.files.internal("GUI.json")), "label");
        scoreLabel.setPosition(100f, 100f);
        scoreLabel.setFontScale(0.8f);
        stage.addActor(scoreLabel);
        menuGUI = new MenuGUI(viewport);
    }

    @Override
    public void update() {
        super.update();
        menuGUI.update();
    }

    @Override
    public void draw() {
        super.draw();
        menuGUI.draw();
    }

    @Override
    public void dispose() {
        menuGUI.dispose();
        super.dispose();
    }
}
