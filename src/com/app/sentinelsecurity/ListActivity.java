package com.app.sentinelsecurity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public abstract class ListActivity extends Activity {
	ListView items;
	DbData dbData;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dbData = new DbData(this);
		questions = getQuestions();

		setContentView(R.layout.activity_questions);
		items = (ListView) findViewById(R.id.items);
		createHeader();
		items.setAdapter(new QuestionsAdapter(this, getCurrentContext(), questions));

		Button next = (Button) findViewById(R.id.button_next);
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), getNextClass());
				startActivity(intent);
			}
		});

		Button back = (Button) findViewById(R.id.button_back);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity) getActivity()).finish();
			}
		});

		items.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final Question item = (Question) parent.getItemAtPosition(position);
				Intent i = new Intent(getApplicationContext(), SingleQuestionActivity.class);
				i.putExtra("question", item.getQuestion());
				startActivity(i);
			}
		});
	}

	private void createHeader() {
		View headerView = getLayoutInflater().inflate(R.layout.activity_questions_header, null);
		TextView header = (TextView) headerView.findViewById(R.id.header);
		header.setText(getHeaderTitle());
		items.addHeaderView(headerView);
	}

	protected abstract Class<?> getNextClass();

	protected abstract Context getActivity();

	protected abstract Activity getCurrentActivity();

	protected abstract List<Question> createQuestions();

	protected abstract Context getCurrentContext();

	protected abstract String getHeaderTitle();

	protected ListView getListView() {
		return items;
	}

	private List<Question> getQuestions() {
		if (questions == null) {
			questions = createQuestions();
		} else {
			questions = dbData.getQuestionsFromDB();
		}
		return questions;
	}
}
