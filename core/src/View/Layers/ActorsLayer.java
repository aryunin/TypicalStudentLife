package View.Layers;

import View.Layer;

public class ActorsLayer extends Layer {
    public ActorsLayer() {
        addObject(new Model.RecordBook(0, 0));
    }
}
