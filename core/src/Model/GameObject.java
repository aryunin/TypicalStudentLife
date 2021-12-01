package Model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

abstract public class GameObject {
    private Sprite sprite;
    private Polygon bounds;

    public GameObject(TextureRegion region, float posX, float posY, float width, float height, float angle) {
        bounds = new Polygon();
        bounds.setVertices(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(posX, posY);
        bounds.setOrigin(width/2,height/2);
        bounds.setRotation(angle);

        sprite = new Sprite(region);
        sprite.setPosition(posX, posY);
        sprite.setSize(width, height);
        sprite.setOrigin(width/2,height/2);
        sprite.setRotation(angle);
    }

    public void draw(SpriteBatch batch) {
        sprite.setPosition(bounds.getX(), bounds.getY());
        sprite.setRotation(bounds.getRotation());
        sprite.draw(batch);
    }

    public Polygon getBounds() {
        return bounds;
    }

    public void move(float offsetX, float offsetY) {
        bounds.setPosition(bounds.getX() + offsetX, bounds.getY() + offsetY);
    }

    public abstract void update();
}
