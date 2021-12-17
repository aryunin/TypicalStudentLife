package Tools;

import Model.GameObjects.GameObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;

public class CollisionChecker {
    static public void check(GameObject actor, Array<GameObject> collisionLayer) {
        for (GameObject object : collisionLayer) {
            if (Intersector.intersectPolygons(new FloatArray(actor.getBounds().getTransformedVertices()),
                    new FloatArray(object.getBounds().getTransformedVertices()))) {
                actor.intersectWith(object);
            }
        }
    }
}
