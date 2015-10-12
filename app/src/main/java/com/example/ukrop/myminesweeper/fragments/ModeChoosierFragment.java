package com.example.ukrop.myminesweeper.fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
        final View view = inflater.inflate(R.layout.mode_choosier_layout, container, false);
        MainActivity.setIsInMainMenu(false);
        final FragmentManager manager = getFragmentManager();

        ImageButton beginner = (ImageButton) view.findViewById(R.id.button_beginner_mode);
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.main_frame_layout,
                                FieldFragment.newInstance
                                        (GameModes.beinner_rows,
                                                GameModes.beginner_cols,
                                                GameModes.beginner_bombs))
                        .commit();
            }
        });

        ImageButton advanced = (ImageButton) view.findViewById(R.id.button_advanced_mode);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.main_frame_layout,
                                FieldFragment.newInstance
                                        (GameModes.advanced_rows,
                                                GameModes.advanced_cols,
                                                GameModes.advanced_bombs))
                        .commit();
            }
        });

        ImageButton expert = (ImageButton) view.findViewById(R.id.button_expert_mode);
        expert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .replace(R.id.main_frame_layout,
                                FieldFragment.newInstance
                                    (GameModes.expert_rows,
                                            GameModes.expert_cols,
                                            GameModes.expert_bombs))
                        .commit();
            }
        });

        ImageButton custom = (ImageButton) view.findViewById(R.id.button_custom_mode);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new CustomModeDialogFragment();
                dialog.show(getFragmentManager(), "CUSTOM_MODE_DIALOG");
            }
        });

        return view;
    }
}
