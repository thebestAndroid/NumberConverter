package com.example.numbersconverter;

import com.example.numbersconverter.sn.BinarySN;
import com.example.numbersconverter.sn.DemicalSN;
import com.example.numbersconverter.sn.EightSN;
import com.example.numbersconverter.sn.SixteenSN;
import com.example.numbersconverter.sn.SystemNumeration;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class Control extends Activity implements OnClickListener {
	Spinner spinner_scc;
	Spinner spinner_hcc;
	EditText editText_scc;
	EditText editText_hcc;
    Button[] mass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_control);
		
		editText_scc = (EditText) findViewById(R.id.editText_scc);
		editText_hcc = (EditText) findViewById(R.id.editText_hcc);
		
		spinner_scc = (Spinner) findViewById(R.id.spinner_scc);
		String [] data = getResources().getStringArray(R.array.array_type_sn);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_scc.setAdapter(adapter);
		spinner_scc.setSelection(2);
		spinner_scc.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				editText_scc.setText(new String());
				
				long result  = 0L;
				switch(arg2){
				case 0 :
					result = 2;
					break;
				case 1 :
					result = 8;
					break;
				case 2 :
					result = 10;
					break;
				case 3 :
					result = 16;
					break;
				}
				enableButton(result);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		spinner_hcc = (Spinner) findViewById(R.id.spinner_hcc);
		spinner_hcc.setAdapter(adapter);
		spinner_hcc.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				calculate();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	 
	   mass = new Button[18];
	   mass[0] = (Button) findViewById(R.id.button4);
	   mass[1] = (Button) findViewById(R.id.button5);
	   mass[2] = (Button) findViewById(R.id.button1);
	   mass[3] = (Button) findViewById(R.id.button2);
	   mass[4] = (Button) findViewById(R.id.button3);
	   mass[5] = (Button) findViewById(R.id.button6);
	   mass[6] = (Button) findViewById(R.id.button7);
	   mass[7] = (Button) findViewById(R.id.button8);
	   mass[8] = (Button) findViewById(R.id.button9);
	   mass[9] = (Button) findViewById(R.id.button10);
	   mass[10] = (Button) findViewById(R.id.button11);
	   mass[11] = (Button) findViewById(R.id.button12);
	   mass[12] = (Button) findViewById(R.id.button13);
	   mass[13] = (Button) findViewById(R.id.button14);
	   mass[14] = (Button) findViewById(R.id.button15);
	   mass[15] = (Button) findViewById(R.id.button16);
	   mass[16] = (Button) findViewById(R.id.button17);
	   mass[17] = (Button) findViewById(R.id.button18);
	   
	   for (Button x: mass) {
		 x.setOnClickListener(this);
	   }
	 editText_scc.setInputType(0);
	 editText_hcc.setInputType(0);
	 
	 Button button_spinner = (Button) findViewById(R.id.button_spinner);
	 button_spinner.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			int x = spinner_scc.getSelectedItemPosition();
			spinner_scc.setSelection(spinner_hcc.getSelectedItemPosition());
			spinner_hcc.setSelection(x);
			
		}
	});
	}

	private void calculate() {
		if(editText_scc.getText().toString().length() == 0) return;
		SystemNumeration sn = null;
		byte scc, hcc;
		scc = (byte) spinner_scc.getSelectedItemId();
		hcc = (byte) spinner_hcc.getSelectedItemId();
		boolean rule = false;
		switch (scc) {
		case 0:
			rule = new BinarySN().rule(editText_scc.getText().toString());
			scc = 2;
			break;
		case 1:
			rule = new EightSN().rule(editText_scc.getText().toString());
			scc = 8;
			break;
		case 2:
			rule = new DemicalSN().rule(editText_scc.getText().toString());
			scc = 10;
			break;
		case 3:
			rule = new SixteenSN().rule(editText_scc.getText().toString());
			scc = 16;
			break;
		}
		if (rule == false)
			return;
		switch (hcc) {
		case 0:
			sn = new BinarySN();
			break;
		case 1:
			sn = new EightSN();
			break;
		case 2:
			sn = new DemicalSN();
			break;
		case 3:
			sn = new SixteenSN();
			break;
		}
		String result = sn.getNewNumber(editText_scc.getText().toString(), scc);
		editText_hcc.setText(result);

	}
	private void enableButton(long scc){
		for (Button x : mass) {
			x.setEnabled(false);
		}
		for (int i = 0; i <scc+2; i++) {
			mass[i].setEnabled(true);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.control, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == mass[0].getId()){
			editText_scc.setText(editText_scc.getText().toString() + ".");
		}else if(v.getId() == mass[1].getId()){
			String line = editText_scc.getText().toString();
			if(line.length() == 0){editText_hcc.setText("");return;}
			editText_scc.setText(line.substring(0, line.length() - 1));
			if(editText_scc.getText().length() == 0) editText_hcc.setText("");
		}else if(v.getId() == mass[2].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "0");
		}else if(v.getId() == mass[3].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "1");
		}else if(v.getId() == mass[4].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "2");
		}else if(v.getId() == mass[5].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "3");
		}else if(v.getId() == mass[6].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "4");
		}else if(v.getId() == mass[7].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "5");
		}else if(v.getId() == mass[8].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "6");
		}else if(v.getId() == mass[9].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "7");
		}else if(v.getId() == mass[10].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "8");
		}else if(v.getId() == mass[11].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "9");
		}else if(v.getId() == mass[12].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "A");
		}else if(v.getId() == mass[13].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "B");
		}else if(v.getId() == mass[14].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "C");
		}else if(v.getId() == mass[15].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "D");
		}else if(v.getId() == mass[16].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "E");
		}else if(v.getId() == mass[17].getId()){
			editText_scc.setText(editText_scc.getText().toString() + "F");
		}
			
			calculate();
	}
	
	@Override
	public void onBackPressed() {
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
	    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
	}

}
