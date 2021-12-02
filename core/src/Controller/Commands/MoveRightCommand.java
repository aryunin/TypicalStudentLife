package Controller.Commands;

import Controller.Command;
import Controller.ObjectController;

public class MoveRightCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveRight();
    }
}
