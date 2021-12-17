package Controller.Commands;

import Controller.ObjectControllers.ObjectController;

public class MoveRightCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveRight();
    }
}
