package com.pongclone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pongclone.game.PongCloneGame;
import com.pongclone.ui.MainMenuMainUI;
import com.pongclone.ui.MainMenuSingleOptionsUI;

/**
 * Created by Philipp on 03.02.2015.
 */
public class MainMenuScreen implements Screen
{
    private PongCloneGame game;

    private Stage stage;
    private MainMenuMainUI mainUI;
    private MainMenuSingleOptionsUI singleOptionsUI;


    public MainMenuScreen(PongCloneGame game)
    {
        this.game = game;


    }

    private void setupSingleUI()
    {
        singleOptionsUI.setStartButtonListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                super.clicked(event, x, y);
                game.singlePlayerScreen.setDifficulty(singleOptionsUI.getSelectedDifficulty());
                game.setScreen(game.singlePlayerScreen);
            }
        });

        singleOptionsUI.setBackButtonListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                super.clicked(event, x, y);
                singleOptionsUI.remove();
                stage.addActor(mainUI);
            }
        });
    }

    private void setupMainUI()
    {
        mainUI.setStartSingleButtonListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                super.clicked(event, x, y);
                mainUI.remove();
                stage.addActor(singleOptionsUI);
            }
        });

        mainUI.setQuitButtonListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void show()
    {
        stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        mainUI = new MainMenuMainUI(skin);
        setupMainUI();
        stage.addActor(mainUI);

        singleOptionsUI = new MainMenuSingleOptionsUI(skin);
        setupSingleUI();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta)
    {
        update(delta);

        stage.draw();
    }

    private void update(float delta)
    {
        stage.act();
    }

    @Override
    public void resize(int width, int height)
    {
        stage.getViewport().update(width, height, false);
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
        stage.dispose();
    }

    @Override
    public void dispose()
    {

    }
}
