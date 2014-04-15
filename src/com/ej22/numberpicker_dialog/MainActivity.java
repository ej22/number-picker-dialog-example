package com.ej22.numberpicker_dialog;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			Button btn = (Button)rootView.findViewById(R.id.dialogBtn);
			btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					show();
				}
				
			});
			return rootView;
		}
		
		public void show(){
			final Dialog npDialog = new Dialog(getActivity());
			npDialog.setTitle("NumberPicker Example");
			npDialog.setContentView(R.layout.numberpicker_layout);
			Button setBtn = (Button)npDialog.findViewById(R.id.setBtn);
			Button cnlBtn = (Button)npDialog.findViewById(R.id.CancelButton_NumberPicker);
			
			final NumberPicker numberPicker = (NumberPicker)npDialog.findViewById(R.id.numberPicker);
			numberPicker.setMaxValue(10);
			numberPicker.setMinValue(0);
			numberPicker.setWrapSelectorWheel(false);
			numberPicker.setOnValueChangedListener(new OnValueChangeListener(){
				@Override
				public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
					// TODO Auto-generated method stub
				}
			});
			
			setBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Toast.makeText(getActivity(), "Number selected: " + numberPicker.getValue() , Toast.LENGTH_SHORT).show();
					
					npDialog.dismiss();
				}
			});
			
			cnlBtn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					npDialog.dismiss();
				}
			});
			
			npDialog.show();
		}
	}

}
