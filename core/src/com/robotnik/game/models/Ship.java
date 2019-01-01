package com.robotnik.game.models;

import com.badlogic.gdx.math.Rectangle;

public abstract class Ship {
    private Rectangle rectangle;

    public boolean checkCollision(final Rectangle rectangle){
        return this.rectangle.overlaps(rectangle);
    }
}
