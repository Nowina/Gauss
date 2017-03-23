package com.example.nowina.gauss.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nowina.gauss.R;
import com.example.nowina.gauss.grid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txt = (EditText)findViewById(R.id.txt1);
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt.getText().toString().trim().length() == 0 )
                {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.insert, Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    String count = txt.getText().toString();
                    Toast toast = Toast.makeText(getApplicationContext(), "OKAY", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this, grid.class);
                    intent.putExtra("Count", count);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}
