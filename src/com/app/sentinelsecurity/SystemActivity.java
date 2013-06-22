package com.app.sentinelsecurity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class SystemActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected Map<Integer, String> getQuestionsMap() {
		Map<Integer, String> questions = new HashMap<Integer, String>();
		questions.put(R.string.system_1, DbData.Q_SYSTEM_1);
		questions.put(R.string.system_2, DbData.Q_SYSTEM_2);
		questions.put(R.string.system_3, DbData.Q_SYSTEM_3);
		questions.put(R.string.system_4, DbData.Q_SYSTEM_4);
		questions.put(R.string.system_5, DbData.Q_SYSTEM_5);
		questions.put(R.string.system_6, DbData.Q_SYSTEM_6);
		questions.put(R.string.system_7, DbData.Q_SYSTEM_7);
		questions.put(R.string.system_8, DbData.Q_SYSTEM_8);
		questions.put(R.string.system_9, DbData.Q_SYSTEM_9);
		questions.put(R.string.system_10, DbData.Q_SYSTEM_10);
		questions.put(R.string.system_11, DbData.Q_SYSTEM_11);
		questions.put(R.string.system_12, DbData.Q_SYSTEM_12);
		questions.put(R.string.system_13, DbData.Q_SYSTEM_13);
		questions.put(R.string.system_14, DbData.Q_SYSTEM_14);
		return questions;
	}

	@Override
	protected Class<?> getNextClass() {
		return SupervisoryActivity.class;
	}

	@Override
	protected Context getActivity() {
		return SystemActivity.this;
	}

	@Override
	protected Context getCurrentContext() {
		return context;
	}

	@Override
	protected String getHeaderTitle() {
		return "System";
	}

	@Override
	protected Activity getCurrentActivity() {
		return this;
	}
}
