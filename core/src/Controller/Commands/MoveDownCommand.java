package Controller.Commands;

import Controller.ObjectControllers.ObjectController;

public class MoveDownCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveDown();
    }
}
