package com.pongclone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pongclone.game.PongCloneGame;
import com.pongclone.game.controllers.BallController;
import com.pongclone.game.controllers.LocalPaddleController;
import com.pongclone.game.controllers.SinglePlayerFieldController;
import com.pongclone.game.controls.PlayerKeyboardLayoutInfo;
import com.pongclone.game.models.Ball;
import com.pongclone.game.models.Paddle;
import com.pongclone.game.views.BallRenderer;
import com.pongclone.game.views.PaddleRenderer;
import com.pongclone.ui.GameDifficulty;

/**
 * Created by Philipp on 11.02.2015.
 */
public class SinglePlayerScreen implements Screen
{
    private PongCloneGame game;
    private SpriteBatch sb;

    private Paddle paddleOne;
    private Paddle paddleTwo;

    private PaddleRenderer paddleRenderer;
    private LocalPaddleController playerOneController;
    private LocalPaddleController playerTwoController;

    private Ball ball;
    private BallController ballController;
    private BallRenderer ballRenderer;

    private GameDifficulty difficulty;

    private Rectangle gameField;
    private ShapeRenderer sr;

    private SinglePlayerFieldController singlePlayerFieldController;

    public SinglePlayerScreen(PongCloneGame game)
    {
        this.game = game;
    }

    @Override
    public void show()
    {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();

        gameField = new Rectangle(50, 100, 700, 400);

        ball = new Ball(
            new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2),
            new Vector2(0, 0),
            10,
            100.0f);

        ballController = new BallController(ball);
        ballRenderer = new BallRenderer(ball);

        paddleRenderer = new PaddleRenderer();

        float paddleXOffset = 75;
        Vector2 paddleSize = new Vector2(7, 50);
        float paddleSpeed = 150f;

        paddleOne = new Paddle(
                new Vector2(paddleXOffset, Gdx.graphics.getHeight() / 2 - paddleSize.y / 2),
                paddleSize,
                paddleSpeed);

        paddleTwo = new Paddle(
                new Vector2(Gdx.graphics.getWidth() - paddleXOffset, Gdx.graphics.getHeight() / 2 - paddleSize.y / 2),
                paddleSize,
                paddleSpeed);


        PlayerKeyboardLayoutInfo playerOneLayout = new PlayerKeyboardLayoutInfo();
        playerOneLayout.UP = Input.Keys.W;
        playerOneLayout.DOWN = Input.Keys.S;

        PlayerKeyboardLayoutInfo playerTwoLayout = new PlayerKeyboardLayoutInfo();
        playerTwoLayout.UP = Input.Keys.UP;
        playerTwoLayout.DOWN = Input.Keys.DOWN;

        playerOneController = new LocalPaddleController(paddleOne, playerOneLayout);
        playerTwoController = new LocalPaddleController(paddleTwo, playerTwoLayout);

        InputMultiplexer imp = new InputMultiplexer();
        imp.addProcessor(playerOneController);
        imp.addProcessor(playerTwoController);
        Gdx.input.setInputProcessor(imp);


        paddleRenderer.addPaddle(paddleOne);
        paddleRenderer.addPaddle(paddleTwo);


        singlePlayerFieldController = new SinglePlayerFieldController(paddleOne, paddleTwo, ball, gameField);

    }

    @Override
    public void render(float deltaTime)
    {
        update(deltaTime);



        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.BLACK);
        sr.rect(gameField.getX(), gameField.getY(), gameField.getWidth(), gameField.getHeight());
        sr.line(400, 100, 0, 400, 500, 0);
        sr.end();

        sb.begin();
        paddleRenderer.render(sb);
        ballRenderer.render(sb);
        sb.end();
    }

    private void update(float deltaTime)
    {
        playerOneController.update(deltaTime);
        playerTwoController.update(deltaTime);
        ballController.update(deltaTime);

        singlePlayerFieldController.update(deltaTime);
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

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
