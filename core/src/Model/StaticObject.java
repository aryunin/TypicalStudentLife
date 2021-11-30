package Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticObject extends GameObject {
    public StaticObject(TextureRegion region, float posX, float posY, float width, float height, float angle) {
        super(region, posX, posY, width, height, angle);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update(float delta) {

    }
}
