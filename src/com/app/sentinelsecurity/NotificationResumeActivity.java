package com.app.sentinelsecurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.Question;

public class NotificationResumeActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected Map<Integer, String> getQuestionsMap() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(R.string.notification_resume_1, "Q_NOTIFICATION_RESUME_1");
		questions.put(R.string.notification_resume_2, "Q_NOTIFICATION_RESUME_2");
		questions.put(R.string.notification_resume_3, "Q_NOTIFICATION_RESUME_3");
		return questions;
	}

	@Override
	protected Class<?> getNextClass() {
		return NotificationActivity.class;
	}

	@Override
	protected Context getActivity() {
		return NotificationResumeActivity.this;
	}

	@Override
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "Notifications Resume";
	}

	@Override
	protected Activity getCurrentActivity() {
		return this;
	}
}
