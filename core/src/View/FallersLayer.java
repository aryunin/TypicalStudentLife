package View;

import Tools.FallersFactory;
import com.badlogic.gdx.Gdx;

import static com.artemiiik.tsl.Main.random;

public class FallersLayer extends Layer {
    private float getRandomFloat(float min, float max) {
        return min + random.nextFloat() * (max - min + 1);
    }

    public void createRandomFaller() {
        FallersFactory fallersFactory = FallersFactory.getRandomFactory();
        float fallerPosX = getRandomFloat(100f, Gdx.graphics.getWidth()-200f);
        float fallerPosY = Gdx.graphics.getHeight();
        addObject(fallersFactory.create(fallerPosX, fallerPosY));
    }
}
