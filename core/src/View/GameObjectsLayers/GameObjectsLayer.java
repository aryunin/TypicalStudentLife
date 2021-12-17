package View.GameObjectsLayers;

import Model.GameObjects.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

abstract public class GameObjectsLayer {
    public Array<GameObject> objects;

    public GameObjectsLayer() {
        objects = new Array<>();
    }

    public void update() {
        for(GameObject object : objects) object.update();
    }

    public void draw(SpriteBatch batch) {
        for(GameObject object : objects) object.draw(batch);
    }
}
