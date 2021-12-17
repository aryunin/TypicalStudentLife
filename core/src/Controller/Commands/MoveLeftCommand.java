package Controller.Commands;

import Controller.ObjectControllers.ObjectController;

public class MoveLeftCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveLeft();
    }
}
