package View.Layers;

import View.Layer;

public class BackgroundLayer extends Layer {
    public BackgroundLayer() {
        addObject(new Model.Background(0, 0));
    }
}
