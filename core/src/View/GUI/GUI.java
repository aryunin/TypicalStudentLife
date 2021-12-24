package View.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

abstract public class GUI {
    protected Stage stage;

    public GUI(Viewport viewport) {
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    public void draw() {
        stage.draw();
    }

    public void update() {
        stage.act();
    }

    public void dispose() {
        stage.dispose();
    }
}
