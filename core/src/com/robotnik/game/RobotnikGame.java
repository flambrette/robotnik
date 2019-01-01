package com.robotnik.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.robotnik.game.models.Font;
import com.robotnik.game.screens.HelpScreen;
import com.robotnik.game.screens.Level1Screen;
import com.robotnik.game.screens.MainMenuScreen;

public class RobotnikGame extends Game {

	public MainMenuScreen mainMenuScreen;
	public Level1Screen level1Screen;
	public HelpScreen helpScreen;

	@Override
	public void create() {
		mainMenuScreen = new MainMenuScreen(this);
		level1Screen = new Level1Screen(this);
		helpScreen = new HelpScreen(this);
		setScreen(mainMenuScreen);
	}
}
