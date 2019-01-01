package com.robotnik.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.robotnik.game.RobotnikGame;
import com.robotnik.game.models.Font;
import com.robotnik.game.utils.AssetsUtils;

public class MainMenuScreen implements Screen {

    private RobotnikGame game;
    private Stage stage;
    private Texture background;
    private Font font;

    private TextButton optionsButton;
    private TextButton helpMenuButton;

    private Skin skin = new Skin(Gdx.files.internal( "skin/skin/star-soldier-ui.json" ));

    private Music music;

    private Table table;

    public MainMenuScreen(final RobotnikGame game) {
        this.game = game;
        create();
    }

    private void create() {
        stage = new Stage();
        font = new Font();
        table = new Table();
        table.debug();
        Gdx.input.setInputProcessor(stage);
        background = new Texture(AssetsUtils.BACKGROUND_MAIN_MENU);

        music = Gdx.audio.newMusic(Gdx.files.internal(AssetsUtils.SOUND_MENU_SONG));
        music.setLooping(true);

        optionsButton = new TextButton("Options",skin);
        helpMenuButton = new TextButton("Help Menu", skin);
        helpMenuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.helpScreen);
            }
        });
        table.setFillParent(true);
        table.add(helpMenuButton).width(200);
        table.row();

        table.add(optionsButton).width(150);
        table.row();
        stage.addActor(table);
    }

    @Override
    public void render(final float delta) {

        //update and draw
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);

        //font.draw(stage.getBatch(), "pwet", (Gdx.graphics.getWidth() / 2) -25, Gdx.graphics.getHeight() / 2);


        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        stage.dispose();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        music.play();
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
        music.stop();
    }
}
