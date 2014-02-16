package com.tile.learnintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	
	
	private Button btnCong2So,btnMessager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mapWidget();
		
//		btnCong2So.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i = new Intent(MainActivity.this,Cong_2_So.class);
//				startActivity(i);
//			}
//		});
		
		btnCong2So.setOnClickListener(this);
		btnMessager.setOnClickListener(this);
		
	}
	
	
	/**
	 * Map 
	 */
	private void mapWidget(){
		btnCong2So = (Button)findViewById(R.id.btn_cong2so);
		btnMessager = (Button)findViewById(R.id.btn_messager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.btn_messager:
			Intent i = new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:0969009006"));
			i.putExtra("sms_body", "hello tile!"); // sms_body
			startActivity(i);
			break;
		case R.id.btn_cong2so:
			Intent i1 = new Intent(MainActivity.this,Cong_2_So.class);
			startActivity(i1);
			break;
		default:
				break;
		}
		
	}

}
