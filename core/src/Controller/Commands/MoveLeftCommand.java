package Controller.Commands;

import Controller.Command;
import Controller.ObjectController;

public class MoveLeftCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveLeft();
    }
}
