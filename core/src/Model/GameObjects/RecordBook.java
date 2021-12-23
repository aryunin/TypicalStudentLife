package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class RecordBook extends GameObject implements GoodFaller{
    public RecordBook(float posX, float posY) {
        super(Assets.getAtlas("GameObjects.atlas").findRegion("recordbook"), posX, posY, 100f, 56.25f, 0f);
        setController(new FallerController(this));
    }
}
