package com.example.nowina.gauss.others;

import android.widget.ListAdapter;

/**
 * Created by Nowina on 2017-03-24.
 */

public class Filler {
    int[][] lhs;
    int[] rhs;
    int count;
    TextFieldAdapter adapter;
    public Filler(TextFieldAdapter mAdapter, int mCount)
    {
        count = mCount;
        adapter = mAdapter;
        int[][] lhs = new int[count][count]; //creating table containing x,y,z..... values
        int[] rhs = new int[count];          //creating table containing values on the right side of equation
    }

    public void fill()
    {
        for (int i  = 0; i < count; i++)
        {
            for (int j = 0; j < count; j++)
            {
                lhs[i][j] = Integer.parseInt(adapter.getItemByXY(i,j).getText().toString());
            }
        }
        for (int i = 0; i < count; i++)
        {
            rhs[i] = Integer.parseInt(adapter.getItemByXY(count + 1,i).getText().toString());
        }
    }
    public int[][] getLhs(){
        return lhs;
    }

    public int[] getRhs() {
        return rhs;
    }
}
