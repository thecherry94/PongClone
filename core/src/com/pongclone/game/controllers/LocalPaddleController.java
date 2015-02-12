package com.pongclone.game.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.pongclone.game.Controller;
import com.pongclone.game.controls.PlayerKeyboardLayoutInfo;
import com.pongclone.game.listeners.LocalPaddleEventListener;
import com.pongclone.game.models.Ball;
import com.pongclone.game.models.Paddle;

/**
 * Created by Philipp on 11.02.2015.
 */
public class LocalPaddleController implements Controller, InputProcessor
{
    private Paddle paddle;
    private PlayerKeyboardLayoutInfo keyboardLayout;

    private boolean upPressed;
    private boolean downPressed;

    private boolean leftSide;

    private LocalPaddleEventListener localPaddleEventListener;

    public LocalPaddleController(Paddle paddle, PlayerKeyboardLayoutInfo kbl)
    {
        this.paddle = paddle;
        this.keyboardLayout = kbl;

        leftSide = paddle.getPos().x < Gdx.graphics.getWidth() / 2;
    }

    @Override
    public void update(float deltaTime)
    {
        float direction = 0;
        if(upPressed)
            direction = 1f;
        else if(downPressed)
            direction = -1f;

        Vector2 paddlePos = paddle.getPos();
        paddlePos.y += paddle.getSpeed() * deltaTime * direction;
        paddle.setPos(paddlePos);
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if(keycode == keyboardLayout.UP)
            upPressed = true;
        else if(keycode == keyboardLayout.DOWN)
            downPressed = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(keycode == keyboardLayout.UP)
            upPressed = false;
        else if(keycode == keyboardLayout.DOWN)
            downPressed = false;

        return false;
    }

    public LocalPaddleEventListener getLocalPaddleEventListener() {
        return localPaddleEventListener;
    }

    public void setLocalPaddleEventListener(LocalPaddleEventListener localPaddleEventListener) {
        this.localPaddleEventListener = localPaddleEventListener;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
