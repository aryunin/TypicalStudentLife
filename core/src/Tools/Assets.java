package Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    static private AssetManager manager;

    public Assets() {
        manager = new AssetManager();
        // loading atlas
        manager.load("TestAtlas.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    static public TextureAtlas getAtlas(String fileName) {
        return manager.get(fileName);
    }

    public void dispose() {
        manager.dispose();
    }
}
