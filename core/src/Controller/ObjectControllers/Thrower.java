package Controller.ObjectControllers;

import Controller.ObjectController;
import Model.GameObject;
import com.badlogic.gdx.Gdx;

import static View.GameScreen.deltaCff;

public class Thrower extends ObjectController {
    private GameObject faller;
    private float speed;

    public Thrower(GameObject faller) {
        this.faller = faller;
        speed = Gdx.graphics.getHeight()/2f;
    }

    @Override
    public void update() {
        if (faller.getBounds().getY() <= 0) faller.delete();
        else moveDown();
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {
        faller.move(0,-speed*deltaCff);
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
