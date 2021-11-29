/*
 * Created by aryunin on 2021.11.28
 * TypicalStudentLife
 */

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
		// ex. ((GameScreen)gameScreen).setTextureAtlas(assets.getManager().get("atlas.atlas"));
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
		assets.dispose();
	}
}
