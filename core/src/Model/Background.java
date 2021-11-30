package Model;

import Controller.ObjectController;
import Controller.RBController;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background extends GameObject{

    public Background(TextureAtlas atlas, float posX, float posY) {
        super(atlas.findRegion("BG"), posX, posY, 1417, 945, 0);
    }

    @Override
    public void update() {

    }
}
