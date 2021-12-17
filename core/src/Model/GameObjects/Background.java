package Model.GameObjects;

import Tools.Assets;

public class Background extends GameObject{
    public Background(float posX, float posY) {
        super(Assets.getAtlas("Background.atlas").findRegion("background"), posX, posY, 1024, 768, 0);
    }
}
