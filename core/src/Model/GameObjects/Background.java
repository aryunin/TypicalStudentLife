package Model.GameObjects;

import Tools.Assets;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background extends GameObject{
    public Background(float posX, float posY) {
        super(new TextureRegion(Assets.getTexture("background.jpg")), posX, posY, 1024f, 768f, 0f);
    }
}
