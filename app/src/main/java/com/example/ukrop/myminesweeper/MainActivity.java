package com.example.ukrop.myminesweeper;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ukrop.myminesweeper.fragments.MainMenuFragment;
import com.example.ukrop.myminesweeper.fragments.ModeChoosierFragment;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_exit_icon);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        setTitle("");

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, new MainMenuFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //set action to android.R.id.home
        return super.onOptionsItemSelected(item);
    }
}
