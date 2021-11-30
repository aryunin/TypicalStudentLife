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
		// adding texture atlases to screens
		((GameScreen)gameScreen).setTextureAtlas(assets.getAtlas("TestAtlas.atlas"));
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		assets.dispose();
	}
}
