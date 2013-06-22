package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.Question;

public class NotificationActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected List<Question> createQuestions() {
		List<Question> questions = new ArrayList<Question>();
		Map<String, Question> questionsMap = new HashMap<String, Question>();

		Question question1 = new Question();
		question1.setQuestion(getResources().getString(R.string.notification_1));
		questions.add(question1);
		questionsMap.put("Q_NOTIFY_1", question1);
		
		Question question2 = new Question();
		question2.setQuestion(getResources().getString(R.string.notification_2));
		questions.add(question2);
		questionsMap.put("Q_NOTIFY_2", question2);
		
		Question question3 = new Question();
		question3.setQuestion(getResources().getString(R.string.notification_3));
		questions.add(question3);
		questionsMap.put("Q_NOTIFY_3", question3);
		
		dbData.insertQuestions(questionsMap);
		
		return questions;
	}

	@Override
	protected Class<?> getNextClass() {
		return SystemActivity.class;
	}

	@Override
	protected Activity getActivity() {
		return NotificationActivity.this;
	}

	@Override
	protected List<Question> getQuestions() {
		if (questions == null) {
			questions = createQuestions();
		} else {
			questions = dbData.getQuestionsFromDB();
		}
		return questions;
	}

	@Override
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "Notifications";
	}

	@Override
	protected Activity getCurrentActivity() {
		return this;
	}
}
