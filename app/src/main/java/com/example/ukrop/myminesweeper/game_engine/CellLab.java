package com.example.ukrop.myminesweeper.game_engine;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for creating array of booleans for minefield
 */
public class CellLab {
    private Cell[][] mCells;
    private int mBombs;
    private int mRows;
    private int mCols;

    private static final String TAG = "CellLab";

    public CellLab(int bombs, int rows){
        mCells = new Cell[rows][rows];

        this.mBombs = bombs;
        this.mRows = rows;
        this.mCols = rows;

        initField();
    }

    private void initField(){

        //creating cell array
        for (int i = 0; i < mRows;i++){
            for (int j = 0; j < mCols;j++){
                mCells[i][j] = new Cell(false,false,0);
            }
        }

        //placing bombs
        Random rnd = new Random(System.currentTimeMillis());
        for (int e = 0; e < mBombs; e++){
            int cc = rnd.nextInt(mRows);
            int cr = rnd.nextInt(mCols);
            if (!mCells[cr][cc].isHasBomb()){
                mCells[cr][cc].setHasBomb(true);
                mCells[cr][cc].setNeighbourSize(-1);
            }else {
                while (mCells[cr][cc].isHasBomb()){
                    cc = rnd.nextInt(mRows);
                    cr = rnd.nextInt(mCols);
                }
                mCells[cr][cc].setHasBomb(true);
                mCells[cr][cc].setNeighbourSize(-1);
            }
        }

        //calculating neighbour bomb size
        for (int i = 0; i< mRows;i++) {
            for (int j = 0; j < mCols; j++) {
                if (!mCells[i][j].isHasBomb()){
                    int neighbourSize = 0;
                    for (int e = i - 1;e <= i+1;e++){
                        for (int d = j -1;d <= j+1;d++){
                            try {
                                if (mCells[e][d].isHasBomb()) neighbourSize++;
                            }catch (Exception ignored){}
                        }
                        mCells[i][j].setNeighbourSize(neighbourSize);
                    }
                }
            }
        }
    }

    public int getCount(){
        return mCells.length * mRows;
    }

    public Cell[][] getCells(){
        return mCells;
    }

    /**
     * Method for showing minefield in log
     * */
    private void cellLabLog(){
        ArrayList<Integer> logArray = new ArrayList<Integer>();
        for (int i = 0; i < mRows;i++){
            for (int j = 0; j < mCols;j++){
                logArray.add(mCells[i][j].getNeighbourSize());
            }
        }
        Log.i(TAG, "field: " + logArray);
    }
}
