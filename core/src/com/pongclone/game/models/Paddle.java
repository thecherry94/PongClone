package com.pongclone.game.models;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Philipp on 11.02.2015.
 */
public class Paddle
{
    private Vector2 pos;
    private Vector2 size;
    private float speed;

    public Paddle()
    {
        pos = new Vector2();
        size = new Vector2();
        speed = 0.0f;
    }

    public Paddle(Vector2 pos, Vector2 size, float speed)
    {
        this.pos = pos;
        this.size = size;
        this.speed = speed;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
