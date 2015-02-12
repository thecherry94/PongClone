package com.pongclone.game.controllers;

import com.badlogic.gdx.math.Vector2;
import com.pongclone.game.Controller;
import com.pongclone.game.models.Ball;

/**
 * Created by Philipp on 12.02.2015.
 */
public class BallController implements Controller
{
    private Ball ball;
    private boolean isMoving;

    public BallController(Ball ball)
    {
        this.ball = ball;
        isMoving = true;

        ball.setDir(new Vector2(0, 1));
        ball.getDir().rotate(45);
        ball.setSpeed(200);
    }

    @Override
    public void update(float deltaTime)
    {
        if(!isMoving)
            return;

        if(!ball.getDir().isUnit())
            ball.getDir().nor();

        Vector2 ballPos = ball.getPos();
        ballPos.x += ball.getDir().x * ball.getSpeed() * deltaTime;
        ballPos.y += ball.getDir().y * ball.getSpeed() * deltaTime;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
}
