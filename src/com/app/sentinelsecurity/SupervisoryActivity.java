package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class SupervisoryActivity extends ListActivity {
	Context context = this;
	List<Question> questions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected List<Question> getQuestionsList() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(getResources().getString(R.string.supervisory_1), DbData.Q_SUPERVISORY_1_YES,
				DbData.Q_SUPERVISORY_1_NO, DbData.Q_SUPERVISORY_1_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_2), DbData.Q_SUPERVISORY_2_YES,
				DbData.Q_SUPERVISORY_2_NO, DbData.Q_SUPERVISORY_2_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_3), DbData.Q_SUPERVISORY_3_YES,
				DbData.Q_SUPERVISORY_3_NO, DbData.Q_SUPERVISORY_3_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_4), DbData.Q_SUPERVISORY_4_YES,
				DbData.Q_SUPERVISORY_4_NO, DbData.Q_SUPERVISORY_4_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_5), DbData.Q_SUPERVISORY_5_YES,
				DbData.Q_SUPERVISORY_5_NO, DbData.Q_SUPERVISORY_5_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_6), DbData.Q_SUPERVISORY_6_YES,
				DbData.Q_SUPERVISORY_6_NO, DbData.Q_SUPERVISORY_6_COMMENT));
		questions.add(new Question(getResources().getString(R.string.supervisory_7), DbData.Q_SUPERVISORY_7_YES,
				DbData.Q_SUPERVISORY_7_NO, DbData.Q_SUPERVISORY_7_COMMENT));
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
