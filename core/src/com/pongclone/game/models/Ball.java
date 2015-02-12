package com.pongclone.game.models;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Philipp on 12.02.2015.
 */
public class Ball
{
    private Vector2 pos;
    private Vector2 dir;
    private float radius;
    private float speed;


    public Ball()
    {
        pos = new Vector2();
        dir = new Vector2();
        radius = 0.0f;
        speed = 0.0f;
    }

    public Ball(Vector2 pos, Vector2 dir, float radius, float speed)
    {
        this.pos = pos;
        this.dir = dir;
        this.radius = radius;
        this.speed = speed;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Vector2 getDir() {
        return dir;
    }

    public void setDir(Vector2 dir) {
        this.dir = dir;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
