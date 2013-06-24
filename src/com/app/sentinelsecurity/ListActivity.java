package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
		questions = getQuestions(1L);

		setContentView(R.layout.activity_questions);
		items = (ListView) findViewById(R.id.items);
		createHeader();
		items.setAdapter(new QuestionsAdapter(this, getCurrentContext(), questions, 1L));

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

	protected abstract Context getCurrentContext();

	protected abstract String getHeaderTitle();

	protected abstract Map<Integer, String> getQuestionsMap();

	protected ListView getListView() {
		return items;
	}

	private List<Question> getQuestions(Long id) {
		Cursor cursor1 = dbData.getQuestionsFromDB(1L);
		if (cursor1 == null) {
			questions = createQuestions(getQuestionsMap());
		} else {
			questions = createQuestions(getQuestionsMap());
			Cursor cursor = dbData.getQuestionsFromDB(1L);
			questions = getQuestionsFromCursor(cursor);

		}
		return questions;
	}

	protected List<Question> createQuestions(Map<Integer, String> questionsNames) {
		List<Question> questions = new ArrayList<Question>();
		Map<String, Question> questionsMap = new HashMap<String, Question>();
		Question question;

		for (Map.Entry<Integer, String> entry : questionsNames.entrySet()) {
			Integer questionName = entry.getKey();
			String questionDbName = entry.getValue();
			question = new Question(getResources().getString(questionName), questionDbName);
			questions.add(question);
			questionsMap.put(questionDbName, question);
		}

		// dbData.insertQuestions(questionsMap);

		return questions;
	}

	private List<Question> getQuestionsFromCursor(Cursor cursor) {
		cursor.moveToFirst();
		for (Question question : questions) {
			// String checked =
			// cursor.getString(cursor.getColumnIndex(question.getDbColumn()));
			int checked = cursor.getInt(cursor.getColumnIndex(question.getDbColumn()));

			question.setIsChecked(checked == 0 ? false : true);

		}
		return questions;
	}
}
