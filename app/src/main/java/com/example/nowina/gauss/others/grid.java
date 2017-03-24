package com.example.nowina.gauss.others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.nowina.gauss.R;

public class grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Intent intent = getIntent();
        final int count = Integer.parseInt(intent.getStringExtra("Count").toString());
        final GridView grid = (GridView)findViewById(R.id.gridview);
        grid.setNumColumns(count + 1);
        final TextFieldAdapter<EditText> adapter = new TextFieldAdapter<EditText>(this,count);
        grid.setAdapter(adapter);

        Button button = (Button)findViewById(R.id.buttonCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filler filler = new Filler(adapter,count);
                filler.fill();

            }
        });
    }
}
