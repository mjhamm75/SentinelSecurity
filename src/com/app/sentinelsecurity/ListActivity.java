package com.app.sentinelsecurity;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.app.sentinelsecurity.domain.Question;

public abstract class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_questions);
		ListView items = (ListView) findViewById(R.id.items);
		items.setAdapter(new QuestionsAdapter(getCurrentContext(), getQuestions()));

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
	}

	protected abstract Class<?> getNextClass();

	protected abstract Context getActivity();

	protected abstract List<Question> getQuestions();

	protected abstract List<Question> createQuestions();

	protected abstract Context getCurrentContext();
}
