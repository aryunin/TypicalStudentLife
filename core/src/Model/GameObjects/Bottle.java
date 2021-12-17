package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class Bottle extends GameObject{
    public Bottle(float posX, float posY) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("Bottle"), posX, posY, 100f, 100f, 0f);
        setController(new FallerController(this));
    }
}