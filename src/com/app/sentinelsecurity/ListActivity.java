package com.app.sentinelsecurity;

import java.util.List;

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
	QuestionsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dbData = new DbData(this);
		questions = getQuestions(1L);

		setContentView(R.layout.activity_questions);
		items = (ListView) findViewById(R.id.items);
		createHeader();
		adapter = new QuestionsAdapter(this, getCurrentContext(), questions, 1L, dbData);
		items.setAdapter(adapter);

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
				i.putExtra("yesChecked", item.getIsYesChecked());
				i.putExtra("noChecked", item.getIsNoChecked());
				i.putExtra("dbYesColumn", item.getDbYesColumn());
				i.putExtra("dbNoColumn", item.getDbNoColumn());
				startActivity(i);
			}
		});
	}
	
	@Override
	protected void onRestart() {
		// Change this
		adapter.notifyDataSetChanged();
		super.onRestart();
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

	protected abstract List<Question> getQuestionsList();

	protected ListView getListView() {
		return items;
	}

	private List<Question> getQuestions(Long id) {
		Cursor cursor1 = dbData.getQuestionsFromDB(1L);
		if (cursor1 == null) {
			questions = getQuestionsList();
		} else {
			questions = getQuestionsList();
			Cursor cursor = dbData.getQuestionsFromDB(1L);
			questions = getQuestionsFromCursor(cursor);

		}
		return questions;
	}

	private List<Question> getQuestionsFromCursor(Cursor cursor) {
		cursor.moveToFirst();
		for (Question question : questions) {
			int checkedYes = cursor.getInt(cursor.getColumnIndex(question.getDbYesColumn()));
			question.setIsYesChecked(checkedYes == 0 ? false : true);
			int checkedNo = cursor.getInt(cursor.getColumnIndex(question.getDbNoColumn()));
			question.setIsNoChecked(checkedNo == 0 ? false : true);
		}
		return questions;
	}
}
