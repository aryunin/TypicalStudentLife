package Model;

import Controller.ObjectControllers.Thrower;

import static View.GameScreen.atlas;

public class Bottle extends GameObject{
    public Bottle(float posX, float posY) {
        super(atlas.findRegion("Bottle"), posX, posY, 100f, 100f, 0f);
        controller = new Thrower(this);
    }
}