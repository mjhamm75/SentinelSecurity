package com.app.sentinelsecurity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SingleQuestionActivity extends Activity {
	protected static final int RESULT_SPEECH = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.single_question);

		Button back = (Button) findViewById(R.id.button_back_single);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SingleQuestionActivity.this.finish();
			}
		});

		ImageButton voice = (ImageButton) findViewById(R.id.button_voice);
		voice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

				try {
					startActivityForResult(intent, 1);
				} catch (ActivityNotFoundException a) {
					Toast t = Toast.makeText(getApplicationContext(),
							"Opps! Your device doesn't support Speech to Text", Toast.LENGTH_SHORT);
					t.show();
				}
			}
		});

		final CheckBox yes = (CheckBox) findViewById(R.id.yes_single);
		boolean isYesChecked = getIntent().getBooleanExtra("yesChecked", false);
		if (isYesChecked) {
			yes.setChecked(true);
		}
		final CheckBox no = (CheckBox) findViewById(R.id.no_single);
		boolean isNoChecked = getIntent().getBooleanExtra("noChecked", false);
		if (isNoChecked) {
			no.setChecked(true);
		}
		yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					no.setChecked(false);
				}
			}
		});
		no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					yes.setChecked(false);
				}
			}
		});

		Intent i = getIntent();
		TextView question = (TextView) findViewById(R.id.question);
		question.setText(i.getStringExtra("question"));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		EditText comment = (EditText) findViewById(R.id.comment);
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case RESULT_SPEECH: {
			if (resultCode == RESULT_OK && null != data) {

				ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

				comment.setText(text.get(0));
			}
			break;
		}
		}
	}

}
