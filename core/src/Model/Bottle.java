package Model;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Bottle extends FallingObject{
    public Bottle(TextureAtlas atlas, float posX, float posY) {
        super(atlas.findRegion("Bottle"), posX, posY, 100f, 100f, 0f);
    }
}