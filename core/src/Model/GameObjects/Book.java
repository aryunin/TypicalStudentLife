package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class Book extends GameObject{
    public Book(float posX, float posY) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("Book"), posX, posY, 100f, 100f, 0f);
        setController(new FallerController(this));
    }
}
