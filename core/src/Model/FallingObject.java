package Model;

import Controller.FallingObjectController;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class FallingObject extends GameObject{
    private FallingObjectController controller;

    public FallingObject(TextureRegion region, FallingObjectController controller, float posX, float posY, float width, float height, float angle) {
        super(region, posX, posY, width, height, angle);
        this.controller = controller;
    }

    @Override
    public void update() {
        controller.update();
    }
}
