package ru.otus.homework01.service;

import ru.otus.homework01.dao.QuizDao;
import ru.otus.homework01.domain.Person;
import ru.otus.homework01.domain.Question;
import ru.otus.homework01.exceptions.IncorrectInputException;

public class InteractServiceImpl implements InteractService {
	
	private static final String NEW_LINE = System.lineSeparator();
	private LoginService loginService;
	private ConsoleService console;
	private QuizDao quizDao;
	
	public InteractServiceImpl(LoginService loginService, QuizDao quizDao, ConsoleService consoleService) {
		this.loginService = loginService;
		this.quizDao = quizDao;
		this.console = consoleService;
	}
	
	public void run() {
		Person person = loginService.getPerson();
		
		greeting(person);
		int score = processTesting();
		processResult(person, score);
		sayGoodBuy();
	}
	
	private int processTesting() {
		
		int score = 0;
		for (Question question : quizDao.getQuiz().getQuestions()) 
			score += scoreAnswer(question, getAnswer(question));
		
		return score;
	}
	
	private String getAnswer(final Question question) {
		
		String line;
		while (true) {
			line = console.getAnswer(NEW_LINE + question.getQuestionText() + ":  ");	
			if (isAnswerValid(line))
				break;
		}
		return line;
	}

	private int scoreAnswer(final Question question, String answer) {
		
		answer = answer.trim();
		if (answer.equals("0"))
			sayGoodBuy();
		
		if (answer.equals(question.getCorrectAnswerId())) {
			console.print("Правильно!");
			return 1;
		}
		else {
			console.print("Это неправильный ответ! Продолжаем ...");
			return 0;
		}
	}

	private void processResult(final Person person, final int score) {
		console.print(
			NEW_LINE + person.toString() + ", Вы набрали " + score + " баллов из " + quizDao.getQuiz().getQuestions().size() + "."
		);
	}
	
	private boolean isAnswerValid(final String answer) {

		try {
			validateAnswer(answer);
		} catch (IncorrectInputException e) {
			console.print("Такого варианта ответа нет. Для ответа введите число от 1 до 3.");
			return false;
		}
		return true;
	}
	
	private void validateAnswer(final String answer) throws IncorrectInputException {
		
		int variant;
		try {
			variant = Integer.parseInt(answer);
		}catch (NumberFormatException e) {
			throw new IncorrectInputException();
		}
		
		if (variant < 0 || variant >3)
			throw new IncorrectInputException();
	}
	
	private void greeting(final Person person){
		console.print("Здравствуйте, " + person.toString() + "!");
		console.print(NEW_LINE + "Ответьте, пожалуйста, на несколько вопросов. Для ответа вводите число от 1 до 3. Для выхода нажмите 0.");
	}
	
	private void sayGoodBuy(){
		console.print(NEW_LINE + "Всего хорошего!");
		System.exit(1);
	}
}
