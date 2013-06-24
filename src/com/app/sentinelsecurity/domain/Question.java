package com.app.sentinelsecurity.domain;

public class Question {
	String question;
	Boolean isYesChecked;
	Boolean isNoChecked;
	String comment;
	String dbYesColumn;
	String dbNoColumn;

	public Question() {
		isYesChecked = false;
		isNoChecked = false;
	}

	public Question(String question, String dbYesColumn, String dbNoColumn) {
		this.question = question;
		this.dbYesColumn = dbYesColumn;
		this.dbNoColumn = dbNoColumn;
		isYesChecked = false;
		isNoChecked = false;
	}

	public Question(String question, Boolean isYesChecked, Boolean isNoChecked, String comment) {
		super();
		this.question = question;
		this.isYesChecked = isYesChecked;
		this.isNoChecked = isNoChecked;
		this.comment = comment;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Boolean getIsYesChecked() {
		return isYesChecked;
	}

	public void setIsYesChecked(Boolean isYesChecked) {
		this.isYesChecked = isYesChecked;
	}

	public Boolean getIsNoChecked() {
		return isNoChecked;
	}

	public void setIsNoChecked(Boolean isNoChecked) {
		this.isNoChecked = isNoChecked;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDbYesColumn() {
		return dbYesColumn;
	}

	public void setDbYesColumn(String dbYesColumn) {
		this.dbYesColumn = dbYesColumn;
	}

	public String getDbNoColumn() {
		return dbNoColumn;
	}

	public void setDbNoColumn(String dbNoColumn) {
		this.dbNoColumn = dbNoColumn;
	}

}
