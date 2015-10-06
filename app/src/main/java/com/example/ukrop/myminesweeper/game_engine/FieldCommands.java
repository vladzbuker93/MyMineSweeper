package com.example.ukrop.myminesweeper.game_engine;

import android.util.Log;

import java.util.ArrayList;

/**
 * Class for all commands on the minefield
 */
public class FieldCommands {
    private ArrayList<Integer> openedTiles;
    private ArrayList<Integer> mAroundBombsArray;
    private ArrayList<Integer> mBombsPositions;
    private int mBombs;
    private int mRows;
    private int mColumn;
    private int mMax_Tiles;

    private static final String TAG = "FieldCommands";

    public FieldCommands(int rows, int bombs,int max_tiles, ArrayList<Integer> bombPositions){
        openedTiles = new ArrayList<Integer>();
        mAroundBombsArray = new ArrayList<Integer>();

        mBombsPositions = bombPositions;
        mBombs = bombs;
        mRows = rows;
        mMax_Tiles = max_tiles;

        aroundBombArray(mBombs,mRows,mMax_Tiles, mBombsPositions);
    }

    public ArrayList<Integer> getmAroundBombsArray() {
        return mAroundBombsArray;
    }

    public ArrayList<Integer> getOpenedTiles() {
        return openedTiles;
    }

    public void openTilesArray(int position) throws ArrayIndexOutOfBoundsException{
        int column = getColumn(position, mRows);

        int position_left = position;
        int position_right = position;
        while(position_left > -1 && !hasNeighbouringBombs(position_left)){
            rowCheck(position_left, position_right, getStartRow(position,column),getEndRow(position,mMax_Tiles,column));
            position_left = position_left - mRows;
            position_right = position_right - mRows;
        }

        position_left = position + mRows;
        position_right = position + mRows;
        while (position_right < mMax_Tiles && !hasNeighbouringBombs(position_left)){
            rowCheck(position_left, position_right, getStartRow(position,column),getEndRow(position,mMax_Tiles,column));
            position_left = position_left + mRows;
            position_right = position_right + mRows;

        }

    }

    /**
     * method for checking a row in minefield
     */
    private void rowCheck(int position_left,int position_right,int row_start,int row_end){

        while (!hasNeighbouringBombs(position_left)){
            checkTile(position_left);
            if (position_left == row_start) break;
            position_left--;
        }

        while (!hasNeighbouringBombs(position_right)){
            checkTile(position_right);
            if (position_right == row_end) break;
            position_right++;
        }

        Log.i(TAG, "rowCheck: " + openedTiles);
    }

    /**
     * method for creating array list with positions of 3x3 space around bomb
     */
    private ArrayList<Integer> aroundBombArray(int bombs, int rows,int max_tiles, ArrayList<Integer> bombPositions){
            for (int i = 0; i < bombs; i++) {
                int column = getColumn(bombPositions.get(i),rows);

                int center_start_row = getStartRow(bombPositions.get(i), column);
                int center_end_row = getEndRow(bombPositions.get(i), max_tiles, column);

                if (bombPositions.get(i) != center_end_row){
                    if (bombPositions.get(i) + 1 <= max_tiles)
                        mAroundBombsArray.add(bombPositions.get(i) + 1);
                    if (bombPositions.get(i) + (rows + 1) <= max_tiles)
                        mAroundBombsArray.add(bombPositions.get(i) + (rows + 1));
                    if (bombPositions.get(i) - (rows + 1) > -1)
                        mAroundBombsArray.add(bombPositions.get(i) - (rows + 1));
                }
                if (bombPositions.get(i) != center_start_row){
                    if (bombPositions.get(i) - 1 > -1)
                        mAroundBombsArray.add(bombPositions.get(i) - 1);
                    if (bombPositions.get(i) + (rows - 1) <= max_tiles)
                        mAroundBombsArray.add(bombPositions.get(i) + (rows - 1));
                    if (bombPositions.get(i) - (rows - 1) > -1)
                        mAroundBombsArray.add(bombPositions.get(i) - (rows - 1));
                }
                if (bombPositions.get(i) + rows <= max_tiles)
                    mAroundBombsArray.add(bombPositions.get(i) + rows);
                if (bombPositions.get(i) - rows > -1)
                    mAroundBombsArray.add(bombPositions.get(i) - rows);
            }
        Log.i(TAG,"bombPosition array: " + bombPositions + " mAroundBombsArray: " + mAroundBombsArray);

        return mAroundBombsArray;
    }

    /**
     * Method that adds position to opened tiles list
     */
    private void checkTile(int position){
        openedTiles.add(position);
    }

    /**
     * Method for checking if position is bombs neighbour
     */
    private boolean hasNeighbouringBombs(int position){
        int hasNeighbour = mAroundBombsArray.indexOf(position);
        return hasNeighbour > -1;
    }

    /**
     * method for getting ending position of the row
     */

    private int getEndRow(int position, int max_tiles, int column){
        int row_end;
        if (position != max_tiles){
            row_end = position + ((mRows - column) - 1);
        }else {
            row_end = max_tiles;
        }
        return row_end;
    }

    /**
     * method for getting starting position of the row
     */
    private int getStartRow(int position, int column){
        int row_start;
        if (position != 0){
            row_start = position - column;
        }else {
            row_start = 0;
        }
        return row_start;
    }

    /**
     * method for getting in column position for clicked tile
     */
    private int getColumn(int position, int rows){
        while (true){
            if (position > mRows){
                mColumn =  position - rows;
                position = position - rows;
            }else{
                mColumn = position;
                break;
            }
        }
        Log.i(TAG, "column: " + mColumn);
        return mColumn;
    }


}
