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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class SingleQuestionActivity extends Activity {
	protected static final int RESULT_SPEECH = 1;
	DbData dbData;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbData = new DbData(this);
		this.setContentView(R.layout.single_question);

		Button back = (Button) findViewById(R.id.button_back_single);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Question question = (Question) v.getTag();
				TextView comment = (TextView) findViewById(R.id.question);
				dbData.updateComment(question.getDbCommentColumn(), comment.getText().toString(), 1L);
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
							"Oops! Your device doesn't support Speech to Text", Toast.LENGTH_SHORT);
					t.show();
				}
			}
		});

		CheckBox yes = (CheckBox) findViewById(R.id.yes_single);
		CheckBox no = (CheckBox) findViewById(R.id.no_single);

		CompoundButton.OnCheckedChangeListener listen = new CompoundButton.OnCheckedChangeListener() {
			boolean proceed = true;

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				switch (buttonView.getId()) {
				case R.id.yes_single:
					if (proceed == true) {
						proceed = false;
						updateQuestion((Question) buttonView.getTag(), isChecked, "yes");
						LinearLayout l = (LinearLayout) buttonView.getParent();
						CheckBox c2 = (CheckBox) l.getChildAt(1);
						if (isChecked) {
							c2.setChecked(false);
							updateQuestion((Question) buttonView.getTag(), false, "no");
						}
						proceed = true;
						break;
					}
				case R.id.no_single:
					if (proceed == true) {
						proceed = false;
						updateQuestion((Question) buttonView.getTag(), isChecked, "no");
						LinearLayout l2 = (LinearLayout) buttonView.getParent();
						CheckBox c1 = (CheckBox) l2.getChildAt(0);
						if (isChecked) {
							c1.setChecked(false);
							updateQuestion((Question) buttonView.getTag(), false, "yes");
						}
						proceed = true;
						break;
					}
				}
			}
		};

		yes.setOnCheckedChangeListener(listen);
		no.setOnCheckedChangeListener(listen);

		setQuestionText();
		setCheckboxesStatus(yes, no);
	}

	public void updateQuestion(Question question, Boolean isChecked, String yesOrNo) {
		if (yesOrNo.equals("no")) {
			dbData.updateQuestion(getIntent().getStringExtra("dbNoColumn"), isChecked, 1L);

		} else {
			dbData.updateQuestion(getIntent().getStringExtra("dbYesColumn"), isChecked, 1L);
		}
	}

	private void setCheckboxesStatus(CheckBox yes, CheckBox no) {
		boolean isYesChecked = getIntent().getBooleanExtra("yesChecked", false);
		if (isYesChecked) {
			yes.setChecked(true);
		}
		boolean isNoChecked = getIntent().getBooleanExtra("noChecked", false);
		if (isNoChecked) {
			no.setChecked(true);
		}
	}

	private void setQuestionText() {
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
