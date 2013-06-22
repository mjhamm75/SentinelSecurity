package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.Question;

public class SupervisoryActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected List<Question> createQuestions() {
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

	@Override
	protected Class<?> getNextClass() {
		return MonitoringActivity.class;
	}

	@Override
	protected Context getActivity() {
		return SupervisoryActivity.this;
	}

	@Override
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "Supervisory";
	}

	@Override
	protected Activity getCurrentActivity() {
		return this;
	}
}
