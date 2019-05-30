package ru.otus.homework01.domain;


public class Question {
	//TODO применить библиотеку Lombok
	private int id;
	private String questionText;
	private int correctAnswerId;
	
	public Question(String id, String questionText, String correctAnswerId) {
		this.id = Integer.valueOf(id.trim());
		this.questionText = questionText;
		this.correctAnswerId = Integer.valueOf(correctAnswerId.trim());
	}
	
	public int getId() {
		return id;
	}
	public String getQuestionText() {
		return questionText;
	}

	public int getCorrectAnswerId() {
		return correctAnswerId;
	}
	
	
}
