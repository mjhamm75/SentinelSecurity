package com.app.sentinelsecurity.domain;

public class Question {
	String question;
	Boolean isChecked;
	String comment;
	String dbColumn;

	public Question() {
		isChecked = false;
	}
	
	public Question(String question, String dbColumn) {
		this.question = question;
		this.dbColumn = dbColumn;
		isChecked = false;
	}

	public Question(String question, Boolean isChecked, String comment) {
		super();
		this.question = question;
		this.isChecked = isChecked;
		this.comment = comment;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDbColumn() {
		return dbColumn;
	}

	public void setDbColumn(String dbColumn) {
		this.dbColumn = dbColumn;
	}

}
