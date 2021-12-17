package com.artemiiik.tsl;

import Tools.Assets;
import View.Screens.GameScreen;
import View.Screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.awt.*;
import java.util.Random;

public class Main extends Game {
	private Screen gameScreen;
	private Screen menuScreen;
	private Assets assets;
	static public Random random;

	@Override
	public void create () {
		assets = new Assets();
		random = new Random();
		gameScreen = new GameScreen(this);
		menuScreen = new MenuScreen(this);
		GameScreen.atlas = assets.getAtlas("GameScreen.atlas");
		MenuScreen.atlas = assets.getAtlas("GameScreen.atlas");
		setScreen(menuScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		menuScreen.dispose();
		assets.dispose();
	}
}
