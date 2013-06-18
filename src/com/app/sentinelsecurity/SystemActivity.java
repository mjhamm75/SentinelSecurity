package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.sentinelsecurity.domain.Question;

public class SystemActivity extends Activity {
	Context context = this;
	QuestionsAdapter adapter;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = createQuestions();
		setContentView(R.layout.activity_questions);

		adapter = new QuestionsAdapter(context, questions);
		ListView systemsItems = (ListView) findViewById(R.id.list_notification);
		systemsItems.setAdapter(adapter);
		
		Button next = (Button)findViewById(R.id.button_next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SystemActivity.this, SupervisoryActivity.class);
				startActivity(intent);
			}
		});

		Button cancel = (Button)findViewById(R.id.button_back);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SystemActivity.this.finish();
			}
		});
	}

	private List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.system_1));
		questions.add(question1);
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.system_2));
		questions.add(question2);
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.system_3));
		questions.add(question3);
		Question question4 = new Question();
		question4.setQuestion(getResources().getString(R.string.system_4));
		questions.add(question4);
		Question question5 = new Question();
		question5.setQuestion(getResources().getString(R.string.system_5));
		questions.add(question5);
		Question question6 = new Question();
		question6.setQuestion(getResources().getString(R.string.system_6));
		questions.add(question6);
		Question question7 = new Question();
		question7.setQuestion(getResources().getString(R.string.system_7));
		questions.add(question7);
		Question question8 = new Question();
		question8.setQuestion(getResources().getString(R.string.system_8));
		questions.add(question8);
		Question question9 = new Question();
		question9.setQuestion(getResources().getString(R.string.system_9));
		questions.add(question9);
		Question question10 = new Question();
		question10.setQuestion(getResources().getString(R.string.system_10));
		questions.add(question10);
		Question question11 = new Question();
		question11.setQuestion(getResources().getString(R.string.system_11));
		questions.add(question11);
		Question question12 = new Question();
		question12.setQuestion(getResources().getString(R.string.system_12));
		questions.add(question12);
		Question question13 = new Question();
		question13.setQuestion(getResources().getString(R.string.system_13));
		questions.add(question13);
		Question question14 = new Question();
		question14.setQuestion(getResources().getString(R.string.system_14));
		questions.add(question14);
		return questions;
	}

}
