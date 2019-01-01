package com.robotnik.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.robotnik.game.RobotnikGame;
import com.robotnik.game.models.Font;

public class Level1Screen implements Screen {

    private RobotnikGame game;
    private Stage stage;
    private Texture background;
    private Music music;

    public Level1Screen(final RobotnikGame game) {
        this.game = game;
        create();
    }

    private void create() {
        stage = new Stage();
        background = new Texture("backgrounds/menu.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/gatlingBoogie.ogg"));
        music.setLooping(true);
        //music.play();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(final float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(final int width, final int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
