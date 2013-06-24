package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

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
	protected List<Question> getQuestionsList() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(getResources().getString(R.string.system_1), DbData.Q_SYSTEM_1_YES, DbData.Q_SYSTEM_1_NO));
		questions.add(new Question(getResources().getString(R.string.system_2), DbData.Q_SYSTEM_2_YES, DbData.Q_SYSTEM_2_NO));
		questions.add(new Question(getResources().getString(R.string.system_3), DbData.Q_SYSTEM_3_YES, DbData.Q_SYSTEM_3_NO));
		questions.add(new Question(getResources().getString(R.string.system_4), DbData.Q_SYSTEM_4_YES, DbData.Q_SYSTEM_4_NO));
		questions.add(new Question(getResources().getString(R.string.system_5), DbData.Q_SYSTEM_5_YES, DbData.Q_SYSTEM_5_NO));
		questions.add(new Question(getResources().getString(R.string.system_6), DbData.Q_SYSTEM_6_YES, DbData.Q_SYSTEM_6_NO));
		questions.add(new Question(getResources().getString(R.string.system_7), DbData.Q_SYSTEM_7_YES, DbData.Q_SYSTEM_7_NO));
		questions.add(new Question(getResources().getString(R.string.system_8), DbData.Q_SYSTEM_8_YES, DbData.Q_SYSTEM_8_NO));
		questions.add(new Question(getResources().getString(R.string.system_9), DbData.Q_SYSTEM_9_YES, DbData.Q_SYSTEM_9_NO));
		questions.add(new Question(getResources().getString(R.string.system_10), DbData.Q_SYSTEM_10_YES, DbData.Q_SYSTEM_10_NO));
		questions.add(new Question(getResources().getString(R.string.system_11), DbData.Q_SYSTEM_11_YES, DbData.Q_SYSTEM_11_NO));
		questions.add(new Question(getResources().getString(R.string.system_12), DbData.Q_SYSTEM_12_YES, DbData.Q_SYSTEM_12_NO));
		questions.add(new Question(getResources().getString(R.string.system_13), DbData.Q_SYSTEM_13_YES, DbData.Q_SYSTEM_13_NO));
		questions.add(new Question(getResources().getString(R.string.system_14), DbData.Q_SYSTEM_14_YES, DbData.Q_SYSTEM_14_NO));
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
