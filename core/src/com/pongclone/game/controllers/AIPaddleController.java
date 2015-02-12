package com.pongclone.game.controllers;

import com.pongclone.game.Controller;
import com.pongclone.game.listeners.LocalPaddleEventListener;
import com.pongclone.game.models.Ball;
import com.pongclone.game.models.Paddle;
import com.pongclone.ui.GameDifficulty;

/**
 * Created by Philipp on 12.02.2015.
 */
public class AIPaddleController implements Controller, LocalPaddleEventListener
{
    private Paddle paddle;
    private Ball ball;
    private GameDifficulty difficulty;

    private int reactionTime;
    private float reactionCounter;

    public AIPaddleController(Paddle paddle, Ball ball, GameDifficulty difficulty)
    {
        this.paddle = paddle;
        this.ball = ball;
        this.difficulty = difficulty;

        reactionCounter = 0.0f;

        switch (difficulty)
        {
            case DIFFICULTY_EASY:
                paddle.setSpeed(120);
                reactionTime = 220;
                break;

            case DIFFICULTY_MEDIUM:
                paddle.setSpeed(130);
                reactionTime = 200;
                break;

            case DIFFICULTY_HARD:
                paddle.setSpeed(140);
                reactionTime = 185;
                break;

            case DIFFICULTY_UNFAIR:
                paddle.setSpeed(175);
                reactionTime = 150;
                break;
        }
    }

    @Override
    public void update(float deltaTime)
    {
        reactionCounter += deltaTime * 1000;

        if(reactionTime < reactionCounter)
        {

        }
    }

    @Override
    public void onBallCollidedWithPlayer()
    {

    }
}
