package com.pongclone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pongclone.game.PongCloneGame;

/**
 * Created by Philipp on 03.02.2015.
 */
public class IntroScreen implements Screen
{
    private PongCloneGame game;
    private Sprite introImage;
    private float screenDuration = 5000;
    private float timeElapsed;

    private SpriteBatch sb;

    public IntroScreen(PongCloneGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        Texture introTexture = new Texture("introImage.png");
        introImage = new Sprite(introTexture);

        introImage.setAlpha(0.0f);
        introImage.setPosition(
                Gdx.graphics.getWidth() / 2 - introImage.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - introImage.getHeight() / 2);

        sb = new SpriteBatch();
    }

    @Override
    public void render(float delta)
    {
        update(delta);

        sb.begin();
        introImage.draw(sb);
        sb.end();
    }

    private void update(float delta)
    {
        timeElapsed += delta * 1000f;
        float alpha = timeElapsed / screenDuration;

        if(alpha >= 1.25f)
            game.setScreen(game.mainMenuScreen);

        introImage.setAlpha(alpha % 1);
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
