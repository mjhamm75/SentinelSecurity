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

public class MonitoringActivity extends Activity {
	Context context = this;
	QuestionsAdapter adapter;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = createQuestions();
		setContentView(R.layout.activity_questions);

		adapter = new QuestionsAdapter(context, questions);
		ListView notifications = (ListView) findViewById(R.id.list_notification);
		notifications.setAdapter(adapter);

		Button next = (Button) findViewById(R.id.button_next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MonitoringActivity.this, NotificationResumeActivity.class);
				startActivity(intent);
			}
		});

		Button cancel = (Button) findViewById(R.id.button_back);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MonitoringActivity.this.finish();
			}
		});
	}

	private List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.monitoring_1));
		questions.add(question1);
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.monitoring_2));
		questions.add(question2);
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.monitoring_3));
		questions.add(question3);
		return questions;
	}

}
