package com.robotnik.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.robotnik.game.RobotnikGame;
import com.robotnik.game.utils.AssetsUtils;

public class HelpScreen implements Screen {

    private RobotnikGame game;
    private Stage stage;
    private Texture background;
    private Sound sound;
    private Table table;
    private Skin skin = new Skin(Gdx.files.internal( "skin/skin/star-soldier-ui.json" ));

    private TextButton returnButton;

    public HelpScreen(final RobotnikGame game) {
        this.game = game;
        create();
    }

    private void create() {
        stage = new Stage();
        table = new Table();
        table.setSize(300,100);
        background = new Texture(AssetsUtils.BACKGROUND_HELP);
        sound = Gdx.audio.newSound(Gdx.files.internal(AssetsUtils.SOUND_HELP_MENU));
        returnButton = new TextButton("Return",skin);
        returnButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.mainMenuScreen);
            }
        });

        table.add(returnButton).width(150);
        table.row();
        table.debug();
        stage.addActor(table);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        sound.play();
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
        sound.stop();
    }

    @Override
    public void dispose() {

    }
}

