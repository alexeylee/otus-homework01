package ru.otus.homework01.domain;

public class Question {
	//TODO применить библиотеку Lombok
	private String id;
	private String questionText;
	private String correctAnswerId;
	
	public Question(String id, String questionText, String correctAnswerId) {
		this.id = id.trim();
		this.questionText = questionText;
		this.correctAnswerId = correctAnswerId.trim();
	}
	
	public String getId() {
		return id;
	}
	public String getQuestionText() {
		return questionText;
	}

	public String getCorrectAnswerId() {
		return correctAnswerId;
	}
	
	
}
