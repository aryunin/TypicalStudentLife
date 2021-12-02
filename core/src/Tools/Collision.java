package Tools;

import Model.GameObject;
import Model.RecordBook;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;

public class Collision {
    private Array<GameObject> actors;
    private Array<GameObject> callers;

    public Collision(Array<GameObject> actors, Array<GameObject> callers)
    {
        this.actors = actors;
        this.callers = callers;
    }

    private void RecordBookFallerCollision(GameObject recordBook, GameObject faller) {
        callers.removeValue(recordBook,true);
    }

    public void check() {
        for (GameObject actor : actors) {
            for (GameObject caller : callers) {
                if (Intersector.intersectPolygons(actor.getBounds(), caller.getBounds(), null)) {
                    switch(actor.getClass().getName()) {
                        case "RecordBook":
                            switch(caller.getClass().getName()) {
                                case "Book":
                                case "Bottle":
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
