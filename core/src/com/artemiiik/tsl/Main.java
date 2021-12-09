package com.artemiiik.tsl;

import Tools.Assets;
import View.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.Random;

public class Main extends Game {
	private Screen gameScreen;
	private Assets assets;
	static public Random random;

	@Override
	public void create () {
		gameScreen = new GameScreen();
		assets = new Assets();
		random = new Random();
		GameScreen.atlas = assets.getAtlas("GameScreen.atlas");
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		assets.dispose();
	}
}
