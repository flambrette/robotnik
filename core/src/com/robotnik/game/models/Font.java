package com.robotnik.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.robotnik.game.utils.AssetsUtils;

public class Font extends Actor {
    private BitmapFont bitmapFont;

    public Font(){
        bitmapFont = new BitmapFont(Gdx.files.internal(AssetsUtils.FONT));
        bitmapFont.setColor(Color.GREEN);
    }

    public Font(final String fontName, final Color color){
        bitmapFont = new BitmapFont(Gdx.files.internal(fontName));
        bitmapFont.setColor(color);
    }

    public void draw(final Batch batch, final String msg, final float x, final float y) {
        bitmapFont.draw(batch, msg, x, y);
    }
}
