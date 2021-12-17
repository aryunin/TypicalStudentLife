package View.GameObjectsLayers;

import Model.GameObjects.RecordBook;

public class RBLayer extends GameObjectsLayer {
    public RBLayer() {
        objects.add(new RecordBook(0, 0));
    }
}
