package com.artemiiik.tsl;

import Tools.Assets;
import View.Screens.GameScreen;
import View.Screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.Random;

public class Main extends Game {
	private Screen gameScreen;
	private Screen menuScreen;
	static public Random random = new Random();

	@Override
	public void create () {
		Assets.load();
		gameScreen = new GameScreen(this);
		menuScreen = new MenuScreen(this);
		GameScreen.atlas = Assets.getAtlas("GameScreen.atlas");
		MenuScreen.atlas = Assets.getAtlas("GameScreen.atlas");
		setScreen(menuScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		menuScreen.dispose();
		Assets.dispose();
	}
}
