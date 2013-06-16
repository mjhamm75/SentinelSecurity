package com.app.sentinelsecurity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.sentinelsecurity.domain.Question;

public class QuestionsAdapter extends ArrayAdapter<Question> {
	List<Question> questions = new ArrayList<Question>();
	Context context;

	public QuestionsAdapter(Context context, int textViewResourceId, List<Question> questions) {
		super(context, textViewResourceId, questions);
		this.questions = questions;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_questions, parent, false);
		TextView question = (TextView)rowView.findViewById(R.id.question);
		question.setText(questions.get(position).getQuestion());
		return rowView;
	}
}
