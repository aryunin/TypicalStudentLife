package Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.geom.Point2D;

public class Actor extends GameObject{
    public Actor(TextureRegion region, Point2D pos, float width, float height, float angle) {
        super(region, pos, width, height, angle);
    }

    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.setPosition(bounds.getX(), bounds.getY());
        sprite.setRotation(bounds.getRotation());
        super.draw(batch);
    }
}
