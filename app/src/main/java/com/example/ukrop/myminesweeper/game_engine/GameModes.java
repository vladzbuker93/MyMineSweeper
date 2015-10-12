package com.example.ukrop.myminesweeper.game_engine;

/**
 * Class that defines game modes
 */
public class GameModes {

    /**
     * Beginner Mode
     */
    public static final int beinner_rows = 7;
    public static final int beginner_cols = 7;
    public static final int beginner_bombs = 6;

    /**
     * Advanced Mode
     */
    public static final int advanced_rows = 9;
    public static final int advanced_cols = 9;
    public static final int advanced_bombs = 20;

    /**
     * Expert Mode
     */
    public static final int expert_rows = 15;
    public static final int expert_cols = 15;
    public static final int expert_bombs = 35;

    /**
     * Custom Mode
     */
    public static final int custom_rows = 0;
    public static final int custom_cols = 0;
    public static final int custom_bombs= 0;

    public int setCustomRows(int rows){
        return rows;
    }
    public int setCustomCols(int cols){
        return cols;
    }
    public int setCustomBombs(int bombs){
        return bombs;
    }
}
