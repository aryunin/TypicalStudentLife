package Model.GameObjects;

import Controller.ObjectControllers.RBController;
import Tools.Assets;

public class RecordBook extends GameObject{
    public RecordBook(float posX, float posY) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("RecordBook"), posX, posY, 80, 65, 0);
        setController(new RBController(this));
    }
}
