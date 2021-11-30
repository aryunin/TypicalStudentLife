package Controller;

public class InputHandler {
    static private Command command;

    static public void handleInput() {
        // Type your commands here
        command = null;
    }

    static public Command getCurrentCommand() {
        return command;
    }
}
