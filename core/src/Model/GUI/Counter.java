package Model.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Counter extends Label {
    final static private float defaultFontScaling = 1f;
    private String name;
    private long count;

    public void scale(float scaling) {
        setFontScale(defaultFontScaling*scaling);
    }

    public Counter(String name, int defaultCount, float posX, float posY, float scaling) {
        super(name + defaultCount, new Skin(Gdx.files.internal("GUI.json")), "label");
        this.name = name;
        count = defaultCount;
        scale(scaling);
        setPosition(posX, posY);
    }

    public void add(int value) {
        count += value;
        setText(name + count);
    }

    public long getCount() {
        return count;
    }
}
