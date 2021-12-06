package Model;

import Controller.ObjectControllers.Thrower;

import static View.GameScreen.atlas;

public class Book extends GameObject{
    public Book(float posX, float posY) {
        super(atlas.findRegion("Book"), posX, posY, 100f, 100f, 0f);
        setController(new Thrower(this));
    }
}
