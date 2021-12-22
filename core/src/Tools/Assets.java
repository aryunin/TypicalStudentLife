package Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets {
    static private AssetManager manager = new AssetManager();

    static public void load() {
        manager.load("GameScreen.atlas", TextureAtlas.class);
        manager.load("background.jpg", Texture.class);
        manager.finishLoading();
    }

    static public TextureAtlas getAtlas(String atlasName) {
        return manager.get(atlasName);
    }

    static public Texture getTexture(String textureName) {
        return manager.get(textureName);
    }

    static public void dispose() {
        manager.dispose();
    }
}
