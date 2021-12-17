package Controller.Commands;

import Controller.ObjectControllers.ObjectController;

public interface Command {
    void execute(ObjectController controller);
}
