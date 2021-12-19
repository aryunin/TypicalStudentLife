package Model.GameObjects;

import Controller.ObjectControllers.RBController;
import Tools.Assets;
import View.Screens.GameScreen;
import com.badlogic.gdx.Screen;

public class RecordBook extends GameObject{
    private Screen mainScreen;

    public RecordBook(float posX, float posY, Screen mainScreen) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("RecordBook"), posX, posY, 80, 65, 0);
        this.mainScreen = mainScreen;
        setController(new RBController(this));
    }

    @Override
    public void intersectWith(GameObject object) {
        if(object.getClass() == Book.class) {
            object.delete();
            ((GameScreen)mainScreen).addScore(1);
        }
        if(object.getClass() == Bottle.class) object.delete();
    }
}
