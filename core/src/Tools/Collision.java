package Tools;

import Model.GameObjects.GameObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;

public class Collision {
    public static int check(GameObject actor, Array<GameObject> collisionLayer) {
        int index = -1;
        for (int i = 0; i < collisionLayer.size; i++) {
            if (Intersector.intersectPolygons(new FloatArray(actor.getBounds().getTransformedVertices()),
                    new FloatArray(collisionLayer.get(i).getBounds().getTransformedVertices()))) {
                index = i;
                break;
            }
        }
        return index;
    }
}
