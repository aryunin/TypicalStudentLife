package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class Feather extends GameObject implements GoodFaller{
    public Feather(float posX, float posY) {
        super(Assets.getAtlas("GameObjects.atlas").findRegion("feather"), posX, posY, 60f, 100f, 0f);
        setController(new FallerController(this));
    }
}