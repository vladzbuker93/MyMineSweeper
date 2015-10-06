package com.example.ukrop.myminesweeper;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ukrop.myminesweeper.fragments.ModeChoosierFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
                .replace(R.id.field_layout, new ModeChoosierFragment())
                .commit();
    }
}
