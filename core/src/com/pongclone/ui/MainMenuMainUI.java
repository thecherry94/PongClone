package com.pongclone.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Philipp on 11.02.2015.
 */
public class MainMenuMainUI extends Table
{
    private TextButton btnStartSingle;
    private TextButton btnStartLocalMulti;
    private TextButton btnStartNetworkMulti;
    private TextButton btnOptions;
    private TextButton btnQuit;

    public MainMenuMainUI(Skin skin)
    {
        super();

        btnStartSingle = new TextButton("Start Singleplayer", skin);
        btnStartLocalMulti = new TextButton("Start Local Multiplayer", skin);
        btnStartNetworkMulti = new TextButton("Start Network Multiplayer", skin);
        btnOptions = new TextButton("Options", skin);
        btnQuit = new TextButton("Quit", skin);

        this.add(btnStartSingle).pad(15);
        this.row();
        this.add(btnStartLocalMulti).pad(15);
        this.row();
        this.add(btnOptions).pad(15);
        this.row();
        this.add(btnQuit).pad(15);

        this.setFillParent(true);
    }



    public void setStartSingleButtonListener(ClickListener listener)
    {
        btnStartSingle.clearListeners();
        btnStartSingle.addListener(listener);
    }

    public void setStartLocalMultiButtonListener(ClickListener listener)
    {
        btnStartLocalMulti.clearListeners();
        btnStartLocalMulti.addListener(listener);
    }

    public void setBtnStartNetworkMultiListener(ClickListener listener)
    {
        btnStartNetworkMulti.clearListeners();
        btnStartNetworkMulti.addListener(listener);
    }

    public void setOptionsButtonListener(ClickListener listener)
    {
        btnOptions.clearListeners();
        btnOptions.addListener(listener);
    }

    public void setQuitButtonListener(ClickListener listener)
    {
        btnQuit.clearListeners();
        btnQuit.addListener(listener);
    }

}
