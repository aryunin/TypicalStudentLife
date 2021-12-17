package View.GameObjectsLayers;

import Tools.FallersFactory;
import com.badlogic.gdx.Gdx;

import static com.artemiiik.tsl.Main.random;

public class FallersLayer extends GameObjectsLayer {
    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    public void createRandomFaller() {
        FallersFactory fallersFactory = FallersFactory.getRandomFactory();
        float fallerPosX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
        float fallerPosY = Gdx.graphics.getHeight();
        objects.add(fallersFactory.create(fallerPosX, fallerPosY));
    }
}
