package com.app.sentinelsecurity.domain;

public class Question {
	String question;
	Boolean isChecked;
	String comment;

	public Question() {
		isChecked = false;
	}
	
	public Question(String question) {
		this.question = question;
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

}
