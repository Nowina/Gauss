package com.example.nowina.gauss.others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nowina.gauss.R;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String[] variables = {"x","y","z","v"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Intent intent = getIntent();
        final TextView textView = (TextView)findViewById(R.id.textSolve);

        final int count = Integer.parseInt(intent.getStringExtra("Count").toString());
        final GridView grid = (GridView)findViewById(R.id.gridview);
        grid.setNumColumns(count + 1);
        final TextFieldAdapter<EditText> adapter = new TextFieldAdapter<EditText>(this,count);
        grid.setAdapter(adapter);
        final Filler filler = new Filler(adapter,count,GridActivity.this);
        Button button = (Button)findViewById(R.id.buttonCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (filler.checkNull()){
                    Toast toast = Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.ToastNull),Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    filler.fill();
                    Matrix A = new Matrix(filler.getLhs());
                    Matrix B = new Matrix(filler.getRhs());
                    Matrix x = new Matrix(3,0);
                    try
                    {
                        x = A.solve(B);
                    }catch (RuntimeException e) { //handling exceptions from Matrix class --> Singular Matrix
                        Toast toast1 = Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.ToastSingular),Toast.LENGTH_SHORT);
                        toast1.show();
                        return;
                    }
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        builder.append(variables[i] + "= ");
                        builder.append(Math.round(x.get(i, 0)));
                        builder.append("\n");
                    }
                    String s = builder.toString();
                    textView.setText(s);
                }
            }
        });
    }
}
