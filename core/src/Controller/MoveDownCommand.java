package Controller;

public class MoveDownCommand implements Command{
    @Override
    public void execute(ObjectController controller) {
        controller.moveDown();
    }
}
