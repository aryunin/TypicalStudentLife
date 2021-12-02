package Controller;

abstract public class ObjectController {
    protected Command command;

    public void update() {
        command = InputHandler.getCurrentCommand();
        if (command != null) {
            command.execute(this);
        }
    }

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
}
