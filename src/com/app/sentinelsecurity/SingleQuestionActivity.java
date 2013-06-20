package com.app.sentinelsecurity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SingleQuestionActivity extends Activity {
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
				Toast.makeText(SingleQuestionActivity.this, "VOICE", Toast.LENGTH_SHORT).show();
			}
		});

		Intent i = getIntent();
		TextView question = (TextView) findViewById(R.id.question);
		question.setText(i.getStringExtra("question"));
	}

}
