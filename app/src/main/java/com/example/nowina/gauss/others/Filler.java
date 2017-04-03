package com.example.nowina.gauss.others;

import android.content.Context;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.nowina.gauss.R;

/**
 * Created by Nowina on 2017-03-24.
 */

public class Filler {
    private double[][] lhs;
    private double[] rhs;
    private int count;
    Context mContext;
    TextFieldAdapter adapter;
    public Filler(TextFieldAdapter mAdapter, int mCount, Context context)
    {
        count = mCount;
        adapter = mAdapter;
        lhs = new double[count][count]; //creating table containing x,y,z..... values
        rhs = new double[count];        //creating table containing values on the right side of equation
        mContext = context;
    }

    public void fill()
    {
        for (int i  = 0; i < count; i++)
        {
            for (int j = 0; j < count; j++)
            {
                String s = adapter.getItemByXY(i,j).getText().toString();
                lhs[i][j] = Double.parseDouble(s);

            }
        }

        for (int i = 0; i < count; i++)
        {
            String s  = adapter.getItemByXY(i,count).getText().toString();
            rhs[i] = Double.parseDouble(s);

        }
    }
    public double[][] getLhs(){
        return lhs;
    }

    public double[] getRhs() {
        return rhs;
    }

    public String printLhs()
    {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < count; i++)
        {
            for (int j = 0; j < count;j ++)
            {
                build.append(lhs[i][j]);
            }
        }
        return build.toString();
    }

    public String printRhs()
    {
        StringBuilder build = new StringBuilder();
        for (int j = 0; j < count;j ++)
        {
            build.append(rhs[j]);
        }
        return build.toString();
    }
    public boolean checkNull()
    {
        boolean empty = true;
        for (int i = 0; i < count; i ++)
        {
            for (int j = 0; j <= count; j++){
                if (adapter.getItemByXY(i,j).toString().equals("")){
                    empty = false;
                }
            }
        }
        return  empty;
    }
}
