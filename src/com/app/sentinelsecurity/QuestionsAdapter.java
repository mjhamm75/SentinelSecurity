package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.app.sentinelsecurity.domain.DbData;
import com.app.sentinelsecurity.domain.Question;

public class QuestionsAdapter extends ArrayAdapter<Question> {
	Context context;
	List<Question> questions = new ArrayList<Question>();
	QuestionHolder holder = null;
	ListView list;
	final DbData dbData;

	public QuestionsAdapter(ListActivity activity, Context context, List<Question> questions, Long id, DbData dbData) {
		super(context, R.layout.row_questions, questions);
		this.questions = questions;
		this.context = context;
		list = activity.getListView();
		this.dbData = dbData;
	}

	@Override
	public View getView(int position, final View convertView, ViewGroup parent) {
		View row = convertView;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.row_questions, parent, false);
			holder = new QuestionHolder();
			holder.question = (TextView) row.findViewById(R.id.question);
			holder.yes = (CheckBox) row.findViewById(R.id.yes);
			holder.no = (CheckBox) row.findViewById(R.id.no);
			row.setTag(holder);
		} else {
			holder = (QuestionHolder) row.getTag();
		}
		Question question = questions.get(position);
		holder.question.setText(question.getQuestion());
		
		setStateCheckboxes(holder, question);
		
		holder.yes.setTag(getItem(position));
		holder.no.setTag(getItem(position));
		holder.yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				updateQuestion((Question) buttonView.getTag(), isChecked, "yes");
				LinearLayout l = (LinearLayout) buttonView.getParent();
				CheckBox c2 = (CheckBox) l.getChildAt(1);
				if (isChecked) {
					c2.setChecked(false);
				}
			}
		});
		holder.no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				updateQuestion((Question) buttonView.getTag(), isChecked, "no");
				LinearLayout l = (LinearLayout) buttonView.getParent();
				CheckBox c1 = (CheckBox) l.getChildAt(0);
				if (isChecked) {
					c1.setChecked(false);
				}
			}
		});
		return row;
	}
	
	private void setStateCheckboxes(QuestionHolder holder, Question question) {
		if(question.getIsYesChecked()) {
			holder.yes.setChecked(true);
		}
		if(question.getIsNoChecked()) {
			holder.no.setChecked(true);
		}
	}

	public void updateQuestion(Question question, Boolean isChecked, String yesOrNo) {
		if (yesOrNo.equals("no")) {
			question.setIsNoChecked(isChecked);
		} else {
			question.setIsYesChecked(isChecked);
		}
		dbData.updateQuestion(question.getDbNoColumn(), isChecked, 1L);
	}

	public class QuestionHolder {
		TextView question;
		CheckBox yes;
		CheckBox no;
	}
}
