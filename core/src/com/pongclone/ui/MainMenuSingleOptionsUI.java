package com.pongclone.ui;

import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Philipp on 11.02.2015.
 */
public class MainMenuSingleOptionsUI extends Table
{
    private SelectBox<DifficultySelectionItem> difficultySelect;
    private Label lblDifficulty;
    private TextButton btnStart;
    private TextButton btnBack;

    public MainMenuSingleOptionsUI(Skin skin)
    {
        lblDifficulty = new Label("Difficulty:", skin);

        DifficultySelectionItem[] difficulties = new DifficultySelectionItem[GameDifficulty.values().length];
        difficulties[0] = new DifficultySelectionItem("Easy", GameDifficulty.DIFFICULTY_EASY);
        difficulties[1] = new DifficultySelectionItem("Medium", GameDifficulty.DIFFICULTY_MEDIUM);
        difficulties[2] = new DifficultySelectionItem("Hard", GameDifficulty.DIFFICULTY_HARD);
        difficulties[3] = new DifficultySelectionItem("Unfair", GameDifficulty.DIFFICULTY_UNFAIR);
        difficultySelect = new SelectBox<DifficultySelectionItem>(skin);
        difficultySelect.setItems(difficulties);

        btnStart = new TextButton("Start", skin);
        btnBack = new TextButton("Go Back", skin);

        this.add(lblDifficulty);
        this.add(difficultySelect).padLeft(5);
        this.row().pad(15);
        this.add(btnStart).left();
        this.add(btnBack).right();

        this.setFillParent(true);
    }


    public GameDifficulty getSelectedDifficulty()
    {
        return difficultySelect.getSelected().getValue();
    }

    public void setStartButtonListener(ClickListener listener)
    {
        btnStart.clearListeners();
        btnStart.addListener(listener);
    }

    public void setBackButtonListener(ClickListener listener)
    {
        btnBack.clearListeners();
        btnBack.addListener(listener);
    }


    public class DifficultySelectionItem
    {
        private String name;
        private GameDifficulty value;

        DifficultySelectionItem(String name, GameDifficulty value)
        {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public GameDifficulty getValue() {
            return value;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
