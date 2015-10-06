package com.example.ukrop.myminesweeper.fragments;

import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ukrop.myminesweeper.R;
import com.example.ukrop.myminesweeper.game_engine.Cell;
import com.example.ukrop.myminesweeper.game_engine.CellLab;
import com.example.ukrop.myminesweeper.game_engine.MinefieldAdapter;


public class FieldFragment extends Fragment{
    private GridView mGridView;
    private MinefieldAdapter mMinefieldAdapter;
    private CellLab mCells;


    private static final String TAG = "FieldFragment";
    private static final String TILES = "tiles";
    private static final String BOMBS = "bombs";
    private static final String ROW_COUNT = "row_count";

    public static FieldFragment newInstance(int tiles, int bombs, int rowCount){
        Bundle args = new Bundle();

        args.putInt(TILES, tiles);
        args.putInt(BOMBS, bombs);
        args.putInt(ROW_COUNT, rowCount);

        FieldFragment fragment = new FieldFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.field_layout, container, false);

        mCells = new CellLab(getArguments().getInt(BOMBS), getArguments().getInt(ROW_COUNT));

        mGridView = (GridView) view.findViewById(R.id.minefield_view);

        mMinefieldAdapter = new MinefieldAdapter(mCells, getActivity());

        mGridView.setNumColumns(getArguments().getInt(ROW_COUNT));
        mGridView.setAdapter(mMinefieldAdapter);
        mGridView.setStretchMode(GridView.NO_STRETCH);

        return view;
    }
}
