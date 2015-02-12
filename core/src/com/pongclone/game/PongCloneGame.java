package com.pongclone.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pongclone.screens.IntroScreen;
import com.pongclone.screens.MainMenuScreen;
import com.pongclone.screens.SinglePlayerScreen;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class PongCloneGame extends Game
{
    public IntroScreen introScreen;
    public MainMenuScreen mainMenuScreen;
    public SinglePlayerScreen singlePlayerScreen;

    private int virtualWidth = 800;
    private int virtualHeight = 600;

    private Camera cam;
    private Viewport viewport;

	@Override
	public void create ()
    {
        cam = new PerspectiveCamera();
        viewport = new FitViewport(virtualWidth, virtualHeight, cam);
        cam.update();

        introScreen = new IntroScreen(this);
        mainMenuScreen = new MainMenuScreen(this);
        singlePlayerScreen = new SinglePlayerScreen(this);
        setScreen(mainMenuScreen);
	}

	@Override
	public void render ()
    {
        Gdx.gl.glClearColor(.8f, .8f, .8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
	}

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
        viewport.update(width, height);
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
