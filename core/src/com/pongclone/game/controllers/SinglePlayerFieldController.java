package com.pongclone.game.controllers;

import com.badlogic.gdx.math.Rectangle;
import com.pongclone.game.Controller;
import com.pongclone.game.models.Ball;
import com.pongclone.game.models.Paddle;

import java.util.ArrayList;

/**
 * Created by Philipp on 12.02.2015.
 */
public class SinglePlayerFieldController implements Controller
{
    private Paddle paddleOne;
    private Paddle paddleTwo;
    private Ball ball;
    private Rectangle gameField;

    private ArrayList<Paddle> paddles;

    public SinglePlayerFieldController(Paddle paddleOne, Paddle paddleTwo, Ball ball, Rectangle gameField)
    {
        this.paddleOne = paddleOne;
        this.paddleTwo = paddleTwo;
        this.ball = ball;
        this.gameField = gameField;

        paddles = new ArrayList<Paddle>();
        paddles.add(paddleOne);
        paddles.add(paddleTwo);
    }

    @Override
    public void update(float deltaTime)
    {
        for(Paddle paddle : paddles)
        {
            if(paddle.getPos().y < gameField.getY())
                paddle.getPos().y = gameField.getY();
            else if(paddle.getPos().y + paddle.getSize().y > gameField.getY() + gameField.getHeight())
                paddle.getPos().y = (gameField.getY() + gameField.getHeight()) - paddle.getSize().y;
        }

        if(ball.getPos().x - ball.getRadius() < gameField.getX() || ball.getPos().x + ball.getRadius() > gameField.getX() + gameField.getWidth())
            ball.getDir().x = -ball.getDir().x;

        if(ball.getPos().y - ball.getRadius() < gameField.getY() || ball.getPos().y + ball.getRadius() > gameField.getY() + gameField.getHeight())
            ball.getDir().y = -ball.getDir().y;
    }
}
