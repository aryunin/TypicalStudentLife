package Controller;

public class MoveUpCommand implements Command{
    @Override
    public void execute(ObjectController controller) {
        controller.moveUp();
    }
}
