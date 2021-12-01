package Controller;

import Model.FallingObject;
import com.badlogic.gdx.Gdx;

import static View.GameScreen.deltaCff;

public class FallingObjectController {
    private FallingObject fallingObject;
    private float speed;

    public FallingObjectController(FallingObject fallingObject) {
        this.fallingObject = fallingObject;
        speed = Gdx.graphics.getHeight()/2f;
    }

    public void update() {
        fallingObject.move(0,-speed*deltaCff);
    }
}
