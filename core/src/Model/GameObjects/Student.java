package Model.GameObjects;

import Controller.ObjectControllers.PlayerController;
import Tools.Assets;

public class Student extends GameObject{
    public Student(float posX, float posY) {
        super(Assets.getAtlas("GameObjects.atlas").findRegion("student"), posX, posY, 54, 120, 0f);
        setController(new PlayerController(this));
    }
}