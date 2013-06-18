package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.app.sentinelsecurity.domain.Question;

public class QuestionsAdapter extends ArrayAdapter<Question> implements OnCheckedChangeListener{
	Context context;
	List<Question> questions = new ArrayList<Question>();

	public QuestionsAdapter(Context context, List<Question> questions) {
		super(context, R.layout.row_questions, questions);
		this.questions = questions;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		QuestionHolder holder = null;

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
		holder.no.setOnCheckedChangeListener(this);
		holder.yes.setOnCheckedChangeListener(this);
		return row;
	}

	public class QuestionHolder {
		TextView question;
		CheckBox yes;
		CheckBox no;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
	}
}
