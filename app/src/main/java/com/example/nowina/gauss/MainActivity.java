package com.example.nowina.gauss;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	private int wymiar = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ShowWynik();
	}

	public void buttonClick(View view){
		
		switch(view.getId())
		{
		
			case R.id.button_plus:
				wymiar += 1;
				break;
			case R.id.button_minus:
				wymiar -= 1;
				break;
	 	}
		
			ShowWynik();
		}
	
	private void ShowWynik() {
		EditText edText1  = (EditText)findViewById(R.id.text1);
		edText1.setText(String.valueOf(wymiar));		
	}

}
