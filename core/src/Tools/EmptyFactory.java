package Tools;

import Model.GameObjects.GameObject;

public interface EmptyFactory {
    GameObject create(float posX, float posY);
}
