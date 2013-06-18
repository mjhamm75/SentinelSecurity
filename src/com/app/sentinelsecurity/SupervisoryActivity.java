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

public class SupervisoryActivity extends Activity {
	Context context = this;
	QuestionsAdapter adapter;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = createQuestions();
		setContentView(R.layout.activity_questions);

		adapter = new QuestionsAdapter(context, questions);
		ListView supervisoryItems = (ListView) findViewById(R.id.list_notification);
		supervisoryItems.setAdapter(adapter);
		
		Button next = (Button)findViewById(R.id.button_next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SupervisoryActivity.this, MonitoringActivity.class);
				startActivity(intent);
			}
		});

		Button cancel = (Button)findViewById(R.id.button_back);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SupervisoryActivity.this.finish();				
			}
		});
	}

	private List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.supervisory_1));
		questions.add(question1);
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.supervisory_2));
		questions.add(question2);
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.supervisory_3));
		questions.add(question3);
		Question question4 = new Question();
		question4.setQuestion(getResources().getString(R.string.supervisory_4));
		questions.add(question4);
		Question question5 = new Question();
		question5.setQuestion(getResources().getString(R.string.supervisory_5));
		questions.add(question5);
		Question question6 = new Question();
		question6.setQuestion(getResources().getString(R.string.supervisory_6));
		questions.add(question6);
		Question question7 = new Question();
		question7.setQuestion(getResources().getString(R.string.supervisory_7));
		questions.add(question7);
		return questions;
	}

}
