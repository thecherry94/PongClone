package com.pongclone.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.pongclone.game.Renderer;
import com.pongclone.game.models.Ball;

/**
 * Created by Philipp on 12.02.2015.
 */
public class BallRenderer implements Renderer, Disposable
{
    private ShapeRenderer sr;
    private Ball ball;

    public BallRenderer(Ball ball)
    {
        this.ball = ball;
        sr = new ShapeRenderer();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.BLACK);
        sr.circle(ball.getPos().x, ball.getPos().y, ball.getRadius() / 2);
        sr.end();
    }

    @Override
    public void dispose()
    {
        sr.dispose();
    }
}
