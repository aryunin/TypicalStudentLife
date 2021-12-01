package Model;

import Controller.FallingObjectController;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class FallingObject extends GameObject{
    protected FallingObjectController controller;

    public FallingObject(TextureRegion region, float posX, float posY, float width, float height, float angle) {
        super(region, posX, posY, width, height, angle);
        controller = new FallingObjectController(this);
    }

    @Override
    public void update() {
        controller.update();
        // TODO
    }
}
