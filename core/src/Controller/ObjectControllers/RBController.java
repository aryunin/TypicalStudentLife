package Controller.ObjectControllers;

import Controller.ObjectController;
import Model.RecordBook;
import com.badlogic.gdx.Gdx;

public class RBController extends ObjectController {
    public RBController(RecordBook recordBook) {
        super(recordBook);
        setSpeed(Gdx.graphics.getWidth()/2f);
    }

    @Override
    public void update() {
        handleCommand();

        float posX = reciever.getBounds().getX();
        float posY = reciever.getBounds().getY();
        float[] bounds = reciever.getBounds().getVertices();

        if(posX < 0) reciever.move(-posX,0);
        if(posX + bounds[2] > Gdx.graphics.getWidth()) reciever.move(Gdx.graphics.getWidth()-bounds[2]-posX,0);
        if(posY < 0) reciever.move(0,-posY);
        if(posY + bounds[6] > 100f) reciever.move(0,100f-bounds[6]-posY);
    }
}
