package Controller.ObjectControllers;

import Model.GameObjects.RecordBook;
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

        if(posX < 0) move(-posX,0);
        if(posX + bounds[2] > Gdx.graphics.getWidth()) move(Gdx.graphics.getWidth()-bounds[2]-posX,0);
        if(posY < 0) move(0,-posY);
        if(posY + bounds[6] > 100f) move(0,100f-bounds[6]-posY);
    }
}
