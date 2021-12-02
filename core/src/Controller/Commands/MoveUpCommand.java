package Controller.Commands;

import Controller.Command;
import Controller.ObjectController;

public class MoveUpCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveUp();
    }
}
