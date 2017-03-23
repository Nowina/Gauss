package com.example.nowina.gauss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

/**
 * Created by Nowina on 2017-02-09.
 */

public class TextFieldAdapter<Type> extends BaseAdapter{

    private Context mContext;
    private int mCount;
    private int item_created_num = 0;
    EditText[][] fields;

    public TextFieldAdapter(Context c){
        mContext = c;
    }

    public TextFieldAdapter(Context c, int count)
    {
        mContext = c;
        mCount = count;
        fields = new EditText[count][count];
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < count; i ++)
        {
            for (int j = 0; j < count; j++)
            {
                fields[i][j] = (EditText) inflater.inflate(R.layout.grid_view_element,null,false);
            }
        }
    }


    @Override
    public int getCount() {
        return mCount*mCount;
    }

    @Override
    public EditText getItem(int position)
    {
        return fields[getPositionX(position)][getPositionY(position)];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position);
    }
    private int getPositionX(int position)
    {
        return position%mCount;
    }

    private int getPositionY(int position)
    {
        return position/mCount;
    }

}
