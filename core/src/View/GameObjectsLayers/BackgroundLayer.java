package View.GameObjectsLayers;

import Model.GameObjects.Background;

public class BackgroundLayer extends GameObjectsLayer {
    public BackgroundLayer() {
        objects.add(new Background(0, 0));
    }
}
