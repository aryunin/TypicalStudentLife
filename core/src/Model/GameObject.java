package Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

import java.awt.geom.Point2D;

abstract public class GameObject {
    Sprite sprite;
    Polygon bounds;

    public GameObject(TextureRegion region, Point2D pos, float width, float height, float angle) {
        bounds = new Polygon();
        bounds.setVertices(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition((float) pos.getX(), (float) pos.getY());
        bounds.setOrigin(width/2,height/2);
        bounds.setRotation(angle);

        sprite = new Sprite(region);
        sprite.setPosition((float) pos.getX(), (float) pos.getY());
        sprite.setSize(width, height);
        sprite.setOrigin(width/2,height/2);
        sprite.setRotation(angle);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public abstract void update(float delta);

    public Polygon getBounds() {
        return bounds;
    }
}
