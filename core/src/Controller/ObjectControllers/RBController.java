package Controller.ObjectControllers;

import Controller.ObjectController;
import Model.RecordBook;
import com.badlogic.gdx.Gdx;

import static View.GameScreen.deltaCff;

public class RBController extends ObjectController {
    private RecordBook recordBook;
    private float speed;
    private float[] bounds;
    private float posX, posY;

    public RBController(RecordBook recordBook) {
        this.recordBook = recordBook;
        bounds = recordBook.getBounds().getVertices();
        posX = recordBook.getBounds().getX();
        posY = recordBook.getBounds().getY();
        speed = Gdx.graphics.getWidth()/2f;
    }

    @Override
    public void update() {
        super.update();

        posX = recordBook.getBounds().getX();
        posY = recordBook.getBounds().getY();
        bounds = recordBook.getBounds().getVertices();

        if(posX < 0) recordBook.move(-posX,0);
        if(posX + bounds[2] > Gdx.graphics.getWidth()) recordBook.move(Gdx.graphics.getWidth()-bounds[2]-posX,0);
        if(posY < 0) recordBook.move(0,-posY);
        if(posY + bounds[6] > 100f) recordBook.move(0,100f-bounds[6]-posY);
    }

    @Override
    public void moveUp() {
        recordBook.move(0,speed*deltaCff);
    }

    @Override
    public void moveDown() {
        recordBook.move(0,-speed*deltaCff);
    }

    @Override
    public void moveLeft() {
        recordBook.move(-speed*deltaCff,0);
    }

    @Override
    public void moveRight() {
        recordBook.move(speed*deltaCff,0);
    }
}
