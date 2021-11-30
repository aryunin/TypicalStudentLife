package Controller;

import Model.Actor;

public interface Command {
    void execute(Actor actor);
}
