package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class MonitoringActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected List<Question> getQuestionsList() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(getResources().getString(R.string.monitoring_1), DbData.Q_MONITORING_1_YES,
				DbData.Q_MONITORING_1_NO));
		questions.add(new Question(getResources().getString(R.string.monitoring_2), DbData.Q_MONITORING_2_YES,
				DbData.Q_MONITORING_2_NO));
		questions.add(new Question(getResources().getString(R.string.monitoring_3), DbData.Q_MONITORING_3_YES,
				DbData.Q_MONITORING_3_NO));
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
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "Monitoring";
	}

	@Override
	protected Activity getCurrentActivity() {
		return this;
	}
}
