package Model.GameObjects;

import Controller.ObjectControllers.RBController;
import Tools.Assets;

public class RecordBook extends GameObject{
    public RecordBook(float posX, float posY) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("RecordBook"), posX, posY, 80f, 65f, 0f);
        setController(new RBController(this));
    }
}
