package Controller.Commands;

import Controller.ObjectControllers.ObjectController;

public class MoveUpCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveUp();
    }
}
