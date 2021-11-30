package Controller;

public class MoveRightCommand implements Command{
    @Override
    public void execute(ObjectController controller) {
        controller.moveRight();
    }
}
