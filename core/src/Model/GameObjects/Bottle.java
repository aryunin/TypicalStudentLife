package Model.GameObjects;

import Controller.ObjectControllers.Thrower;

import static View.Screens.GameScreen.atlas;

public class Bottle extends GameObject{
    public Bottle(float posX, float posY) {
        super(atlas.findRegion("Bottle"), posX, posY, 100f, 100f, 0f);
        setController(new Thrower(this));
    }

    @Override
    public void intersectWith(GameObject object) {

    }
}