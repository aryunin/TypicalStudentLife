package View.UIs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameUI extends UI{
    public GameUI(Viewport viewport) {
        super(viewport, new Skin(Gdx.files.internal("Gui.json")));
    }
}
