package Model;

import Controller.ObjectController;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;

abstract public class GameObject {
    private Sprite sprite;
    private Polygon bounds;
    private ObjectController controller;
    private boolean toDelete;

    public GameObject(TextureRegion region, float posX, float posY, float width, float height, float angle) {
        bounds = new Polygon();
        bounds.setVertices(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(posX, posY);
        bounds.setOrigin(width/2,height/2);
        bounds.setRotation(angle);

        sprite = new Sprite(region);
        sprite.setPosition(posX, posY);        sprite.setSize(width, height);
        sprite.setOrigin(width/2,height/2);
        sprite.setRotation(angle);

        toDelete = false;
    }

    public void draw(SpriteBatch batch) {
        sprite.setPosition(bounds.getX(), bounds.getY());
        sprite.setRotation(bounds.getRotation());
        sprite.draw(batch);
    }

    public Polygon getBounds() {
        return bounds;
    }

    public void setController(ObjectController controller) {
        this.controller = controller;
    }

    public void delete() {
        toDelete = true;
    }

    public boolean toDelete() {
        return toDelete;
    }

    public void update() {
        if(controller != null) controller.update();
    }

    abstract public void intersectWith(GameObject object);
}
