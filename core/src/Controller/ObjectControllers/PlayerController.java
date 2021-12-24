package Controller.ObjectControllers;

import Model.GameObjects.GameObject;
import View.Screens.GameScreen;

public class PlayerController extends ObjectController {
    public PlayerController(GameObject reciever) {
        super(reciever);
        setSpeed(GameScreen.worldWidth/2f);
    }

    @Override
    public void update() {
        handleCommand();

        float posX = reciever.getBounds().getX();
        float posY = reciever.getBounds().getY();
        float spriteWidth = reciever.getBounds().getVertices()[2];
        float spriteHeight = reciever.getBounds().getVertices()[6];

        if(posX < 0) move(-posX,0f);
        if(posX + spriteWidth > GameScreen.worldWidth) move(GameScreen.worldWidth-spriteWidth-posX,0f);
        if(posY < 0) move(0f,-posY);
        if(posY + spriteHeight > 100f) move(0f,100f-spriteHeight-posY);
    }
}
