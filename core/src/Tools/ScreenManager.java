package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;


public class ScreenManager {
    static private Screen currentScreen;
    static public Game main;

    static public void setScreen(Screen newScreen) {
        if(currentScreen != null) currentScreen.dispose();
        currentScreen = newScreen;
        main.setScreen(currentScreen);
    }
}
