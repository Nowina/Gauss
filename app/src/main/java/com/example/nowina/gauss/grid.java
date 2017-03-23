package com.example.nowina.gauss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;

public class grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Intent intent = getIntent();
        int count = Integer.parseInt(intent.getStringExtra("Count").toString());
        final GridView grid = (GridView)findViewById(R.id.gridview);
        grid.setNumColumns(count);
        grid.setAdapter(new TextFieldAdapter<EditText>(this,count));

    }
}
