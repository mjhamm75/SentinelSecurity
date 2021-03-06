package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.DbData;
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
	protected List<Question> getQuestionsList() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(getResources().getString(R.string.notification_1), DbData.Q_NOTIFY_1_YES,
				DbData.Q_NOTIFY_1_NO, DbData.Q_NOTIFY_1_COMMENT));
		questions.add(new Question(getResources().getString(R.string.notification_2), DbData.Q_NOTIFY_2_YES,
				DbData.Q_NOTIFY_2_NO, DbData.Q_NOTIFY_2_COMMENT));
		questions.add(new Question(getResources().getString(R.string.notification_3), DbData.Q_NOTIFY_3_YES,
				DbData.Q_NOTIFY_3_NO, DbData.Q_NOTIFY_3_COMMENT));
		return questions;
	}
}
