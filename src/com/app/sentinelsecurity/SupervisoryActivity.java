package com.app.sentinelsecurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	protected Map<Integer, String> getQuestionsMap() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(R.string.supervisory_1, "Q_SUPERVISORY_1");
		questions.put(R.string.supervisory_2, "Q_SUPERVISORY_2");
		questions.put(R.string.supervisory_3, "Q_SUPERVISORY_3");
		questions.put(R.string.supervisory_4, "Q_SUPERVISORY_4");
		questions.put(R.string.supervisory_5, "Q_SUPERVISORY_5");
		questions.put(R.string.supervisory_6, "Q_SUPERVISORY_6");
		questions.put(R.string.supervisory_7, "Q_SUPERVISORY_7");
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
