package com.example.ukrop.myminesweeper.game_engine;

/**
 * Class that defines game modes
 */
public class GameModes {

    /**
     * Beginner Mode
     */
    public static final int beginner_tiles = 81;
    public static final int beginner_bombs = 8;
    public static final int row_count_beginner = (int) Math.sqrt((double) 81);

    /**
     * Advanced Mode
     */
    public static final int advanced_tiles = 256;
    public static final int advanced_bombs = 40;
    public static final int row_count_advanced = (int) Math.sqrt((double) 256);

    /**
     * Expert Mode
     */
    public static final int expert_tiles = 483;
    public static final int expert_bombs = 100;
    public static final int row_count_expert = (int) Math.sqrt((double) 480);
}
