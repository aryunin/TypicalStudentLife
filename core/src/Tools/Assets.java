package Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    static private AssetManager manager;

    public Assets() {
        manager = new AssetManager();
        manager.load("GameScreen.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    static public TextureAtlas getAtlas(String atlasName) {
        return manager.get(atlasName);
    }

    public void dispose() {
        manager.dispose();
    }
}
