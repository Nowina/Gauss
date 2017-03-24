package com.example.nowina.gauss.others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.nowina.gauss.R;

/**
 * Created by Nowina on 2017-02-09.
 */

public class TextFieldAdapter<Type> extends BaseAdapter{

    private Context mContext;
    private int yCount;
    private int xCount;
    EditText[][] fields;

    public TextFieldAdapter(Context c){
        mContext = c;
    }

    public TextFieldAdapter(Context c, int count)
    {
        mContext = c;
        yCount = count;
        xCount = count +1;

        fields = new EditText[yCount][xCount];
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < count; i ++)
        {
            for (int j = 0; j < count + 1; j++)
            {
                fields[i][j] = (EditText) inflater.inflate(R.layout.grid_view_element,null,false);
            }
        }
    }


    @Override
    public int getCount() {
        return xCount*yCount;
    }

    @Override
    public EditText getItem(int position)
    {
        return fields[getPositionY(position)][getPositionX(position)];
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position);
    }

    public EditText getItemByXY(int x, int y)
    {
        return fields[y][x];
    }
    private int getPositionX(int position)
    {
        return position%xCount;
    }

    private int getPositionY(int position)
    {
        return position/xCount;
    }

}
