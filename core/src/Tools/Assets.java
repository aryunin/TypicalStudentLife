package Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    private AssetManager manager;

    public Assets() {
        manager = new AssetManager();
        // loading atlas
        // ex. manager.load("Atlas.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    public TextureAtlas getAtlas(String fileName) {
        return manager.get(fileName);
    }

    public void dispose() {
        manager.dispose();
    }
}
