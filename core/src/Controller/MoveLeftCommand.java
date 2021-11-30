package Controller;

public class MoveLeftCommand implements Command{
    @Override
    public void execute(ObjectController controller) {
        controller.moveLeft();
    }
}
