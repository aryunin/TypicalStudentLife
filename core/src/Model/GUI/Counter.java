package Model.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Counter extends Label implements Cloneable{
    final static private float defaultFontScaling = 1f;
    private long count;

    public void scale(float scaling) {
        setFontScale(defaultFontScaling*scaling);
    }

    public Counter(int defaultCount, float posX, float posY) {
        super(String.valueOf(defaultCount), new Skin(Gdx.files.internal("GUI.json")), "label");
        count = defaultCount;
        scale(1f);
        setPosition(posX, posY);
    }

    public Counter(int defaultCount, float posX, float posY, float scaling) {
        super(String.valueOf(defaultCount), new Skin(Gdx.files.internal("GUI.json")), "label");
        count = defaultCount;
        scale(scaling);
        setPosition(posX, posY);
    }

    public void add(int value) {
        count += value;
        setText(String.valueOf(count));
    }

    public long getCount() {
        return count;
    }
}
