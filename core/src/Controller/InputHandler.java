package Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHandler {
    static private Command command;

    static public void handleInput() {
        command = null;
        // Type your commands here
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) command = new MoveRightCommand();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) command = new MoveLeftCommand();
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) command = new MoveUpCommand();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) command = new MoveDownCommand();
    }

    static public Command getCurrentCommand() {
        return command;
    }
}
