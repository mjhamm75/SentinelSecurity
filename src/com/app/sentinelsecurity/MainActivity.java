package com.app.sentinelsecurity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class MainActivity extends Activity {
	QuestionsAdapter adapter;
	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button newReport = (Button) findViewById(R.id.button_new_report);
		newReport.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(MainActivity.this);
				dialog.setContentView(R.layout.dialog_new_report);
				dialog.setTitle(R.string.create_report);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//				Button createReport = (Button)v.findViewById(R.id.button_create_report);
//				createReport.setOnClickListener(new View.OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						dialog.dismiss();
//					}
//				});
//
//				Button cancelCreateReport = (Button)v.findViewById(R.id.button_create_report_cancel);
//				cancelCreateReport.setOnClickListener(new View.OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						dialog.dismiss();
//					}
//				});
				dialog.show();
			}
		});
		
		Button editReport = (Button) findViewById(R.id.button_edit_report);
		editReport.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {			
				final Dialog dialog = new Dialog(MainActivity.this);
			}
		});
		// Intent intent = new Intent(this, NotificationActivity.class);
		// startActivity(intent);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Intent intent = new Intent(this, NotificationActivity.class);
		// startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
