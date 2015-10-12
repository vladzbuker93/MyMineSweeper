package com.example.ukrop.myminesweeper.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.ukrop.myminesweeper.R;


public class CustomModeDialogFragment extends DialogFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_mode_dialog, null);
        getDialog().setTitle(R.string.dialog_custom_title);

        final EditText et_Rows = (EditText) view.findViewById(R.id.et_dialog_rows);
        final EditText et_Cols = (EditText) view.findViewById(R.id.et_dialog_cols);
        final EditText et_Bombs = (EditText) view.findViewById(R.id.et_dialog_bombs);

        Button btn_Cancel = (Button) view.findViewById(R.id.dialog_btn_cancel);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getFragmentManager();
            }
        });
        Button btn_Okv = (Button) view.findViewById(R.id.dialog_btn_ok);
        return view;
    }
}
