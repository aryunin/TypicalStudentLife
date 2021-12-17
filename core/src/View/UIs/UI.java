package View.UIs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

abstract public class UI {
    protected Stage stage;
    protected Skin skin;

    public UI(Viewport viewport, Skin skin) {
        stage = new Stage(viewport);
        this.skin = skin;
        Gdx.input.setInputProcessor(stage);
    }

    public void draw() {
        stage.draw();
    }

    public void update() {
        stage.act();
    }

    public void dispose() {
        skin.dispose();
        stage.dispose();
    }
}
