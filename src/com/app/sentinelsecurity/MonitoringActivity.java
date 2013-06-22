package com.app.sentinelsecurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
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
	protected Map<Integer, String> getQuestionsMap() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(R.string.monitoring_1, "Q_MONITORING_1");
		questions.put(R.string.monitoring_2, "Q_MONITORING_2");
		questions.put(R.string.monitoring_3, "Q_MONITORING_3");
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
