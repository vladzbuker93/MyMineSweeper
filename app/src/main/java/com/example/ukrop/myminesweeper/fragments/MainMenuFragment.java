package com.example.ukrop.myminesweeper.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ukrop.myminesweeper.MainActivity;
import com.example.ukrop.myminesweeper.R;

public class MainMenuFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ImageButton newGameBtn = (ImageButton) view.findViewById(R.id.btn_new_game);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_frame_layout, new ModeChoosierFragment())
                            .commit();
            }
        });

        return view;
    }
}
