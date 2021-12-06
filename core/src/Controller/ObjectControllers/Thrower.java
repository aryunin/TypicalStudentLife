package Controller.ObjectControllers;

import Controller.ObjectController;
import Model.GameObject;
import com.badlogic.gdx.Gdx;

import static View.GameScreen.deltaCff;

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
