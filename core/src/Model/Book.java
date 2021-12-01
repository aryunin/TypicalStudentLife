package Model;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Book extends FallingObject{
    public Book(TextureAtlas atlas, float posX, float posY) {
        super(atlas.findRegion("Book"), posX, posY, 100f, 100f, 0f);
    }
}
