package Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.geom.Point2D;

public class StaticObject extends GameObject {
    public StaticObject(TextureRegion region, Point2D pos, float width, float height, float angle) {
        super(region, pos, width, height, angle);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void update(float delta) {

    }
}
