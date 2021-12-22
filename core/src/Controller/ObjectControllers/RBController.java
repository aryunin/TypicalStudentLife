package Controller.ObjectControllers;

import Model.GameObjects.RecordBook;
import View.Screens.GameScreen;

public class RBController extends ObjectController {
    public RBController(RecordBook recordBook) {
        super(recordBook);
        setSpeed(GameScreen.worldWidth/2f);
    }

    @Override
    public void update() {
        handleCommand();

        float posX = reciever.getBounds().getX();
        float posY = reciever.getBounds().getY();
        float[] bounds = reciever.getBounds().getVertices();

        if(posX < 0) move(-posX,0f);
        if(posX + bounds[2] > GameScreen.worldWidth) move(GameScreen.worldWidth-bounds[2]-posX,0f);
        if(posY < 0) move(0f,-posY);
        if(posY + bounds[6] > 100f) move(0f,100f-bounds[6]-posY);
    }
}
