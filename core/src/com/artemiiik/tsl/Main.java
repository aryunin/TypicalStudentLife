package com.artemiiik.tsl;

import Tools.Assets;
import Tools.ScreenManager;
import View.Screens.MenuScreen;
import com.badlogic.gdx.Game;

import java.util.Random;

public class Main extends Game {
	static public Random random = new Random();

	@Override
	public void create () {
		Assets.load();
		ScreenManager.main = this;
		ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void dispose() {
		Assets.dispose();
		super.dispose();
	}
}
// TODO: типы позиций не float
