package ru.otus.homework01.domain;

import java.util.HashMap;
import java.util.List;

public class Quiz {
	private HashMap<String, Question> questionMap;
	
	public Quiz(final List<String[]> csvLines) {
		buildQustionMap(csvLines);
	}
	
	public HashMap<String, Question> getQuestions() {
		return this.questionMap;
	}
	
	private void buildQustionMap(final List<String[]> csvLines) {
		
		this.questionMap = new HashMap<String, Question>();
		for (String[] line : csvLines)
			 this.questionMap.put(
				line[0], 
				new Question(line[0], line[1], line[2])
			);
	}
}
