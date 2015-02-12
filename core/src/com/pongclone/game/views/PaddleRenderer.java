package com.pongclone.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.pongclone.game.Renderer;
import com.pongclone.game.models.Paddle;

import java.util.ArrayList;

/**
 * Created by Philipp on 11.02.2015.
 */
public class PaddleRenderer implements Renderer, Disposable
{
    private ArrayList<Paddle> paddles;
    private ShapeRenderer sr;

    public PaddleRenderer()
    {
        paddles = new ArrayList<Paddle>();
        sr = new ShapeRenderer();
    }

    public void addPaddle(Paddle paddle)
    {
        paddles.add(paddle);
    }

    public void removePaddle(Paddle paddle)
    {
        paddles.remove(paddle);
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.BLACK);
        for(Paddle paddle : paddles)
            sr.box(paddle.getPos().x, paddle.getPos().y, 0, paddle.getSize().x, paddle.getSize().y, 0);
        sr.end();
    }

    @Override
    public void dispose()
    {
        sr.dispose();
    }
}
