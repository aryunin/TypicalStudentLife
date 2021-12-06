package Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Layer {
    public Array<GameObject> objects;

    public Layer() {
        objects = new Array<>();
    }

    public void update() {
        for(GameObject object : objects) object.update();
    }

    public void draw(SpriteBatch batch) {
        for(GameObject object : objects) object.draw(batch);
    }
}