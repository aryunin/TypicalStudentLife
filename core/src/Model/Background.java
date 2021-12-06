package Model;

import static View.GameScreen.atlas;

public class Background extends GameObject{
    public Background(float posX, float posY) {
        super(atlas.findRegion("BG"), posX, posY, 1417, 945, 0);
    }

    @Override
    public void intersectWith(GameObject object) {

    }
}
