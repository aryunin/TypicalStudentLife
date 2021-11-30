package com.artemiiik.tsl;

import Tools.Assets;
import View.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Main extends Game {
	private Screen gameScreen;
	private Assets assets;

	@Override
	public void create () {
		gameScreen = new GameScreen();
		assets = new Assets();
		// adding texture atlasses to screens
		// ex. ((GameScreen)gameScreen).setTextureAtlas(assets.getAtlas("atlas.atlas"));
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		assets.dispose();
	}
}
