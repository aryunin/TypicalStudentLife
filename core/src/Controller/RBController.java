package Controller;

import Model.RecordBook;

import static View.GameScreen.deltaCff;

public class RBController extends ObjectController {
    RecordBook recordBook;
    float speed;


    public RBController(RecordBook recordBook) {
        this.recordBook = recordBook;
        speed = 300;
    }

    @Override
    public void moveUp() {
        //recordBook.move(0,speed*deltaCff);
    }

    @Override
    public void moveDown() {
       // recordBook.move(0,-speed*deltaCff);
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
