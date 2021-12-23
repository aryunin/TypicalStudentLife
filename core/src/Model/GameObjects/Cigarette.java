package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class Cigarette extends GameObject implements BadFaller{
    public Cigarette(float posX, float posY) {
        super(Assets.getAtlas("GameObjects.atlas").findRegion("cigarette"), posX, posY, 100f, 100f, 0f);
        setController(new FallerController(this));
    }
}
