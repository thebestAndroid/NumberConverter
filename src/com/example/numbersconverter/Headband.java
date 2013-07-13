package com.example.numbersconverter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Headband extends Activity implements Runnable{
	private Thread t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_headband);
		
		t = new Thread(this);
		if(!t.isInterrupted()) t.start();
		
		
	}
	
	@Override
	protected void onPause() {
		if(t.isInterrupted()) t.stop();
		super.onPause();
	}


	@Override
	public void run() {
		
		try {
			t.sleep(2000);
		} catch (InterruptedException e) {
			System.exit(0);
		}
		Intent intent = new Intent(getApplicationContext() , Control.class);
		startActivity(intent);
	}

	
}
