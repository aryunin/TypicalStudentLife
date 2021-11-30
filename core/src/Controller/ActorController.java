package Controller;

import Model.Actor;

abstract class ActorController {
    Actor actor;
    Command command;
    public ActorController(Actor actor) {
        this.actor = actor;
        command = InputHandler.getCurrentCommand();
    }
    public abstract void update(float delta);
}
