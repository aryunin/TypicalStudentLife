package Model.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ExitButton extends TextButton {
    final static private float width = 400f;
    final static private float height = 100f;
    final static private float defaultFontScaling = 0.9f;

    private void handleInput() {
        addListener(new InputListener(){
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                setChecked(true);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                setChecked(false);
            }
        });
    }

    public void scale(float scaling) {
        setSize(width*scaling,height*scaling);
        getLabel().setFontScale(defaultFontScaling*scaling);
        getStyle().unpressedOffsetX *= scaling;
        getStyle().pressedOffsetX *= scaling;
        getStyle().checkedOffsetX *= scaling;
    }

    public ExitButton(float posX, float posY) {
        super("Play", new Skin(Gdx.files.internal("GUI.json")), "button");
        scale(1f);
        setPosition(posX, posY);
        handleInput();
    }

    public ExitButton(float posX, float posY, float scaling) {
        super("Play", new Skin(Gdx.files.internal("GUI.json")), "button");
        scale(scaling);
        setPosition(posX, posY);
        handleInput();
    }
}
