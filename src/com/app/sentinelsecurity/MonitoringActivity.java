package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.Question;

public class MonitoringActivity extends ListActivity {
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

	@Override
	protected Class<?> getNextClass() {
		return NotificationResumeActivity.class;
	}

	@Override
	protected Context getActivity() {
		return MonitoringActivity.this;
	}

	@Override
	protected List<Question> getQuestions() {
		if (questions == null) {
			questions = createQuestions();
		}
		return questions;
	}

	@Override
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "Monitoring";
	}
}
