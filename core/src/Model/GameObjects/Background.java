package Model.GameObjects;

import Tools.Assets;

public class Background extends GameObject{
    public Background(float posX, float posY) {
        super(Assets.getAtlas("GameScreen.atlas").findRegion("BG"), posX, posY, 1417, 945, 0);
    }

    @Override
    public void intersectWith(GameObject object) {

    }
}
