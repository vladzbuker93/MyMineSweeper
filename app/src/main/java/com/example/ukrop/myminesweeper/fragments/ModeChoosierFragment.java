package com.example.ukrop.myminesweeper.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ukrop.myminesweeper.MainActivity;
import com.example.ukrop.myminesweeper.R;
import com.example.ukrop.myminesweeper.game_engine.GameModes;


public class ModeChoosierFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mode_choosier_layout, container, false);
        MainActivity.setIsInMainMenu(false);
        final FragmentManager manager = getFragmentManager();
/**
        TextView beginner = (TextView) view.findViewById(R.id.beginner_tv);
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.field_layout,
                                FieldFragment.newInstance
                                        (GameModes.beginner_tiles,
                                                GameModes.beginner_bombs,
                                                GameModes.row_count_beginner))
                        .commit();
            }
        });

        TextView advanced = (TextView) view.findViewById(R.id.advanced_tv);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.field_layout,
                                FieldFragment.newInstance
                                    (GameModes.advanced_tiles,
                                            GameModes.advanced_bombs,
                                            GameModes.row_count_advanced))
                        .commit();
            }
        });

        TextView expert = (TextView) view.findViewById(R.id.expert_tv);
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.field_layout,
                                FieldFragment.newInstance
                                    (GameModes.expert_tiles,
                                            GameModes.expert_bombs,
                                            GameModes.row_count_expert))
                        .commit();
            }
        });
*/
        return view;
    }
}
