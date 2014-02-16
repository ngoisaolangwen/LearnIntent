package com.tile.learnintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Cong extends Activity {
	
	EditText edit_kq;
	Button btn_kq;
	float c_kq = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cong);
		
		
		edit_kq = (EditText)findViewById(R.id.edit_kq);
		edit_kq.setEnabled(false);
		btn_kq = (Button)findViewById(R.id.btn_send_kq);
		
		Intent myIntent = getIntent();
		
		Bundle myB = myIntent.getExtras();
		
		float a_kq = 0;
		float b_kq = 0;
		
		a_kq = myB.getFloat("a");
		b_kq = myB.getFloat("b");
		
		c_kq = a_kq + b_kq;
		
		edit_kq.setText(String.valueOf(a_kq)+ " + " 
		+ String.valueOf(b_kq) + " = " + String.valueOf(c_kq));
		
		btn_kq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				Bundle b = new Bundle();
				b.putFloat("kq", c_kq);
				i.putExtras(b);
				setResult(Activity.RESULT_OK, i);
				finish();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cong, menu);
		return true;
	}

}
