package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.app.sentinelsecurity.domain.Question;

public class MainActivity extends ListActivity {
	QuestionsAdapter adapter;
	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new QuestionsAdapter(context, createQuestions()));
	}
	
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(context, "HERE", Toast.LENGTH_SHORT).show();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Question question = new Question();
		question.setQuestion(getResources().getString(R.string.notification_1));
		questions.add(question);
		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.notification_2));
		questions.add(question1);
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.notification_3));
		questions.add(question2);
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.monitoring_1));
		questions.add(question3);
		return questions;
	}

}
