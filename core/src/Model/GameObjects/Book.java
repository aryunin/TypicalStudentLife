package Model.GameObjects;

import Controller.ObjectControllers.FallerController;
import Tools.Assets;

public class Book extends GameObject implements GoodFaller{
    public Book(float posX, float posY) {
        super(Assets.getAtlas("GameObjects.atlas").findRegion("book"), posX, posY, 100f, 90f, 0f);
        setController(new FallerController(this));
    }
}
