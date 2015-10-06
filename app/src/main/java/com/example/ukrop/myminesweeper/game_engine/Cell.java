package com.example.ukrop.myminesweeper.game_engine;

/**
 * Created by Ukrop on 23.09.2015.
 */
public class Cell {
    private boolean mIsOpen;
    private boolean mHasBomb;
    private int mNeighbourSize;

    public boolean isOpen() {
        return mIsOpen;
    }

    public void setIsOpen(boolean isOpen) {
        mIsOpen = isOpen;
    }

    public boolean isHasBomb() {
        return mHasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        mHasBomb = hasBomb;
    }

    public int getNeighbourSize() {
        return mNeighbourSize;
    }

    public void setNeighbourSize(int neighbourSize) {
        mNeighbourSize = neighbourSize;
    }

    public Cell(boolean isOpen, boolean hasBomb, int neighbourSize){
        this.mIsOpen = isOpen;
        this.mHasBomb = hasBomb;
        this.mNeighbourSize = neighbourSize;
    }
}
