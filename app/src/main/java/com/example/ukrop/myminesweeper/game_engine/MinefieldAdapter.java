package com.example.ukrop.myminesweeper.game_engine;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.ukrop.myminesweeper.R;

import java.util.ArrayList;

/**
 * Adapter for Minefield GridView
 */
public class MinefieldAdapter extends BaseAdapter{

    private Context mContext;
    private CellLab mCells;
    private ViewHolder holder;

    private static final String TAG = "MinefieldAdapter";

    public MinefieldAdapter(CellLab cells, Context context){
        mCells = cells;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mCells.getCount();
    }

    @Override
    public Object getItem(int position) {
        return false;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.minefield_item_layout, parent, false);

            holder = new ViewHolder();
            holder.field_tile = (ImageView) convertView.findViewById(R.id.minefield_tile);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public class ViewHolder{
        ImageView field_tile;
    }
}
