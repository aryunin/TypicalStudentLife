package Controller.ObjectControllers;

import Model.GameObjects.GameObject;
import View.Screens.GameScreen;

public class FallerController extends ObjectController {
    public FallerController(GameObject reciever) {
        super(reciever);
        setSpeed(GameScreen.worldHeight/2f);
    }

    @Override
    public void update() {
        moveDown();
    }
}
