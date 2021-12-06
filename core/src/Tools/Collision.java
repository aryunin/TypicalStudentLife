package Tools;

import Model.GameObject;
import Model.RecordBook;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;

public class Collision {
    private Array<GameObject> actors;
    private Array<GameObject> callers;

    public Collision(Array<GameObject> actors, Array<GameObject> callers)
    {
        this.actors = actors;
        this.callers = callers;
    }

    private void RecordBookFallerCollision(GameObject recordBook, GameObject faller) {
        callers.removeValue(faller,true);
    }

    public void check() {
        for (GameObject actor : actors) {
            for (GameObject caller : callers) {
                if (Intersector.intersectPolygons(new FloatArray(actor.getBounds().getTransformedVertices()),
                        new FloatArray(caller.getBounds().getTransformedVertices()))) {
                    switch(actor.getClass().getName()) {
                        case "Model.RecordBook":
                            switch(caller.getClass().getName()) {
                                case "Model.Book":
                                case "Model.Bottle":
                                    RecordBookFallerCollision(actor,caller);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
