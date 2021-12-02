package Controller.Commands;

import Controller.Command;
import Controller.ObjectController;

public class MoveDownCommand implements Command {
    @Override
    public void execute(ObjectController controller) {
        controller.moveDown();
    }
}
