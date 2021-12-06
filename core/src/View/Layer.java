package View;

import Model.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Layer {
    private Array<GameObject> objects;

    public Layer() {
        objects = new Array<>();
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public GameObject getObject(int index) {
        return objects.get(index);
    }

    public void deleteObject(int index) {
        objects.removeIndex(index);
    }

    public Array<GameObject> getArray() {
        return objects;
    }

    public void update() {
        for(GameObject object : objects) object.update();
    }

    public void draw(SpriteBatch batch) {
        for(GameObject object : objects) object.draw(batch);
    }
}
