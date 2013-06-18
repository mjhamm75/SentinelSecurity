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

public class NotificationActivity extends Activity {
	Context context = this;
	QuestionsAdapter adapter;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = createQuestions();
		setContentView(R.layout.activity_questions);

		adapter = new QuestionsAdapter(context, questions);
		ListView notificationItems = (ListView) findViewById(R.id.list_notification);

		Button next = (Button) findViewById(R.id.button_next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NotificationActivity.this, SystemActivity.class);
				startActivity(intent);
			}
		});

		Button back = (Button) findViewById(R.id.button_back);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationActivity.this.finish();
			}
		});
		
		notificationItems.setAdapter(adapter);
	}

	private List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.notification_1));
		questions.add(question1);
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.notification_2));
		questions.add(question2);
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.notification_3));
		questions.add(question3);
		return questions;
	}

}
