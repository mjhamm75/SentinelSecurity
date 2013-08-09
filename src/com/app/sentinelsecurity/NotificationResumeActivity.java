package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class NotificationResumeActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected List<Question> getQuestionsList() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(getResources().getString(R.string.notification_resume_1),
				DbData.Q_NOTIFICATION_RESUME_1_YES, DbData.Q_NOTIFICATION_RESUME_1_NO,
				DbData.Q_NOTIFICATION_RESUME_1_COMMENT));
		questions.add(new Question(getResources().getString(R.string.notification_resume_2),
				DbData.Q_NOTIFICATION_RESUME_2_YES, DbData.Q_NOTIFICATION_RESUME_2_NO,
				DbData.Q_NOTIFICATION_RESUME_2_COMMENT));
		questions.add(new Question(getResources().getString(R.string.notification_resume_3),
				DbData.Q_NOTIFICATION_RESUME_3_YES, DbData.Q_NOTIFICATION_RESUME_3_NO,
				DbData.Q_NOTIFICATION_RESUME_3_COMMENT));
		return questions;
	}

	@Override
	protected Class<?> getNextClass() {
		return FinalActivity.class;
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
