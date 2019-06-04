package ru.otus.homework01.domain;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	private ArrayList<Question> listOfQuestions;
	
	public Quiz(final List<String[]> csvLines) {
		createListOfQuestions(csvLines);
	}
	
	public ArrayList<Question> getQuestions() {
		return this.listOfQuestions;
	}
	
	private void createListOfQuestions(final List<String[]> csvLines) {
		
		this.listOfQuestions = new ArrayList<>();
		for (String[] line : csvLines)
			this.listOfQuestions.add(
				new Question(line[0].trim(), line[1], line[2].trim())
			);
	}
}
