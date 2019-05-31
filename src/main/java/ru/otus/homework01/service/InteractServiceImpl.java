package ru.otus.homework01.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ru.otus.homework01.IncorrectInputException;
import ru.otus.homework01.domain.Person;
import ru.otus.homework01.domain.Question;

public class InteractServiceImpl implements InteractService {

	private LoginService loginService;
	private ConsoleService consoleService;
	private QuizService quizeService;
	
	public InteractServiceImpl(LoginService loginService, QuizService quizeService, ConsoleService consoleService) {
		this.loginService = loginService;
		this.quizeService = quizeService;
		this.consoleService = consoleService;
	}
	
	public void run() {
		Person person = loginService.getPerson();
		System.out.println("Здравствуйте, " + person.toString());
		
		
		consoleService.close();
	}
	
	private void processTesting() {
		
		Question question;
		
		Iterator listOfQuestions = getQuestions();
		while(listOfQuestions.hasNext()) {

			question = getQuestion(listOfQuestions.next());
			
			
		}
	}
	
	private String getAnswer(Question question) {
		
		String line;
		
		while (true) {
			line = consoleService.getAnswer(question.getQuestionText());
		}
		
		return line;
	}
	
	//TODO проверить, что список вопросов загрузился
	private Iterator getQuestions() {
		HashMap<String, Question> questions = quizeService.getQuiz().getQuestions();
		return questions.entrySet().iterator();
	}
	
	private Question getQuestion(Object next) {
		
		Map.Entry entry = (Map.Entry)next;
		return  (Question)entry.getValue();
	}
	
	private void validateAnswer(String answer) throws IncorrectInputException {
		int variant;
		
		try {
			variant = Integer.parseInt(answer);
		}catch (NumberFormatException e) {
			throw new IncorrectInputException();
		}
	}

}
