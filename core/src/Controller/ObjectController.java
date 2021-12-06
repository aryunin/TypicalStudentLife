package Controller;

import Model.GameObject;

import static View.GameScreen.deltaCff;

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
        command = InputHandler.getCurrentCommand();
        if (command != null) {
            command.execute(this);
        }
    }

    public void moveUp() {
        reciever.move(0,speed*deltaCff);
    }
    public void moveDown() {
        reciever.move(0,-speed*deltaCff);
    }
    public void moveLeft() {
        reciever.move(-speed*deltaCff,0);
    }
    public void moveRight() {
        reciever.move(speed*deltaCff,0);
    }

    abstract public void update();
}
