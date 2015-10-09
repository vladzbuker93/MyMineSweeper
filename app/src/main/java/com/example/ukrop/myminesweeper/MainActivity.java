package com.example.ukrop.myminesweeper;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ukrop.myminesweeper.fragments.MainMenuFragment;

public class MainActivity extends AppCompatActivity{
    public static boolean isInMainMenu = false;

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
        switch (item.getItemId()){
            case android.R.id.home:
                if (!isInMainMenu){
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.main_frame_layout, new MainMenuFragment())
                            .commit();
                }else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setIsInMainMenu(boolean isInMainMenu) {
        MainActivity.isInMainMenu = isInMainMenu;
    }
}
