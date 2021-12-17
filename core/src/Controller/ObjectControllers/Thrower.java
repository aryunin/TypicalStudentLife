package Controller.ObjectControllers;

import Model.GameObjects.GameObject;
import com.badlogic.gdx.Gdx;

public class Thrower extends ObjectController {
    public Thrower(GameObject reciever) {
        super(reciever);
        setSpeed(Gdx.graphics.getHeight()/2f);
    }

    @Override
    public void update() {
        if (reciever.getBounds().getY() <= 0) reciever.delete();
        else moveDown();
    }
}
