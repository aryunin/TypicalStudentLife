package Model;

import Controller.ObjectController;
import Controller.RBController;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class RecordBook extends GameObject{
    private ObjectController controller;

    public RecordBook(TextureAtlas atlas, float posX, float posY) {
        super(atlas.findRegion("RecordBook"), posX, posY, 80, 65, 0);
        controller = new RBController(this);
    }

    @Override
    public void update() {
        controller.update();
    }
}
