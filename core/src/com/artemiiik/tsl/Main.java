/*
 * Created by aryunin on 2021.11.28
 * TypicalStudentLife
 */

package com.artemiiik.tsl;

import View.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Main extends Game {
	private Screen gameScreen;

	@Override
	public void create () {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose () {
		gameScreen.dispose();
	}
}
