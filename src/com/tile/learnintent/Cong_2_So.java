package com.tile.learnintent;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cong_2_So extends Activity {
	
	
	// Tạo các biến để lấy thông tin từ giao diện.
		EditText editA,editB;
		Button btnCong;
		TextView tv;
		
		// Tạo 3 biến chứa.
		private float a,b,Tong;
		
		//a = b = Tong = 0.0;
		private static final int REQUEST_CODE = 11010;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cong_2__so);
		
		
		// Gọi hàm mapScreen().
				mapScreen();
				
				
				// Create listener on button Cộng.
				btnCong.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//
						getNumber();
						Intent intent = new Intent(Cong_2_So.this,Cong.class);
						Bundle bundle = new Bundle();
						bundle.putFloat("a", a);
						bundle.putFloat("b", b);
						intent.putExtras(bundle);
						
						// Send Intent.
						startActivityForResult(intent, REQUEST_CODE);
						
					}
				});
			
	}
	
	/**
	 * Funtion using map id from xml file.
	 */
	private void mapScreen(){
		editA = (EditText)findViewById(R.id.edit_a);
		editB = (EditText)findViewById(R.id.edit_b);
		btnCong = (Button)findViewById(R.id.btn_cong);
		tv = (TextView)findViewById(R.id.txt_get_kq);
	}
	
	/**
	 * Get number from user.
	 */
	private void getNumber(){
		a = partFloat(editA.getText().toString());
		b = partFloat(editB.getText().toString());
		
		Tong = a + b;
		Log.d("Tong", ""+editA.getText().toString() + " + " + editB.getText().toString());
	}
	
	
	/**
	 * partFloat method using get error while....
	 * @param str
	 * @return
	 */
	private float partFloat(String str){
		float fl = 0;
		try{
			fl = Float.parseFloat(str.toString());
		}catch(Exception e){
			// Error.
			Log.d("partFloat", e.getMessage());
		}
		
		return fl;
	}

	/**
	 * Get value from Activity Cong
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		try{
			if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
				Bundle b = data.getExtras();
				tv.append(String.valueOf(b.getFloat("kq")));
			}
		}catch(Exception e){
			// Error
			Log.d("onActivityResult", e.getMessage());
		}
		
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cong_2__so, menu);
		return true;
	}

}
