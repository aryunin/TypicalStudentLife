package Tools;

import Model.GameObjects.GameObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;

public class CollisionChecker {
    private Array<GameObject> actors;
    private Array<GameObject> callers;

    public CollisionChecker(Array<GameObject> actors, Array<GameObject> callers)
    {
        this.actors = actors;
        this.callers = callers;
    }

    public void check() {
        for (GameObject actor : actors) {
            for (GameObject caller : callers) {
                if (Intersector.intersectPolygons(new FloatArray(actor.getBounds().getTransformedVertices()),
                        new FloatArray(caller.getBounds().getTransformedVertices()))) {
                    actor.intersectWith(caller);
                }
            }
        }
    }
}
