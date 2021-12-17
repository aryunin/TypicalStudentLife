package Controller.ObjectControllers;

import Controller.Commands.Command;
import Controller.InputHandler;
import Model.GameObjects.GameObject;

import static View.Screens.GameScreen.deltaCff;

abstract public class ObjectController {
    private Command command;
    private float speed;
    protected GameObject reciever;

    public ObjectController(GameObject reciever) {
        speed = 1f;
        this.reciever = reciever;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void handleCommand() {
        command = InputHandler.command;
        if (command != null) {
            command.execute(this);
        }
    }

    public void move(float offsetX, float offsetY) {
        reciever.getBounds().setPosition(reciever.getBounds().getX() + offsetX, reciever.getBounds().getY() + offsetY);
    }

    public void moveUp() {
        move(0,speed*deltaCff);
    }
    public void moveDown() {
        move(0,-speed*deltaCff);
    }
    public void moveLeft() {
        move(-speed*deltaCff,0);
    }
    public void moveRight() {
        move(speed*deltaCff,0);
    }

    abstract public void update();
}
