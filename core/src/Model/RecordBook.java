package Model;

import Controller.ObjectControllers.RBController;
import Controller.ObjectControllers.Thrower;

import static View.GameScreen.atlas;

public class RecordBook extends GameObject{
    public RecordBook(float posX, float posY) {
        super(atlas.findRegion("RecordBook"), posX, posY, 80, 65, 0);
        setController(new RBController(this));
    }
}
