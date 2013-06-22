package com.app.sentinelsecurity;

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
	protected Class<?> getNextClass() {
		return SystemActivity.class;
	}

	@Override
	protected Activity getActivity() {
		return NotificationActivity.this;
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

	@Override
	protected Map<Integer, String> getQuestionsMap() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(R.string.notification_1, "Q_NOTIFY_1");
		questions.put(R.string.notification_2, "Q_NOTIFY_2");
		questions.put(R.string.notification_3, "Q_NOTIFY_3");
		return questions;
	}
}
