package Tools;

import com.badlogic.gdx.assets.AssetManager;

public class Assets {
    private AssetManager manager;

    public Assets() {
        manager = new AssetManager();
        // loading atlas
        // ex. manager.load("Atlas.atlas", TextureAtlas.class);
        manager.finishLoading();
    }

    public AssetManager getManager() {
        return manager;
    }

    public void dispose() {
        manager.dispose();
    }
}
