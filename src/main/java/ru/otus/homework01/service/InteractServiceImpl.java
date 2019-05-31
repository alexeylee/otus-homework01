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
		
		greeting(person);
		int score = processTesting();
		processResult(person, score);
		consoleService.close();
		sayGoodBuy();
	}
	
	private int processTesting() {
		
		int score = 0;
		Question question;
		
		Iterator<?> listOfQuestions = getQuestions();
		while(listOfQuestions.hasNext()) {

			question = getQuestion(listOfQuestions.next());
			score += scoreAnswer(question, getAnswer(question));
		}
		
		return score;
	}
	
	private String getAnswer(final Question question) {
		
		String line;
		
		while (true) {
			line = consoleService.getAnswer(question.getQuestionText() + ":  ");
			
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
			System.out.println("Правильно!");
			return 1;
		}
		else {
			System.out.println("Это неправильный ответ! Продолжаем ...");
			return 0;
		}
	}
	
	
	
	private void processResult(final Person person, final int score) {
		
		System.out.println(
			person.toString() + ", Вы набрали " + score + " баллов из " + quizeService.getQuiz().getQuestions().size() + "."
		);
	}
	
	//TODO проверить, что список вопросов загрузился
	private Iterator<?> getQuestions() {
		HashMap<String, Question> questions = quizeService.getQuiz().getQuestions();
		return questions.entrySet().iterator();
	}
	
	private Question getQuestion(Object next) {
		
		Map.Entry entry = (Map.Entry)next;
		return  (Question)entry.getValue();
	}
	
	private boolean isAnswerValid(final String answer) {

		try {
			validateAnswer(answer);
		} catch (IncorrectInputException e) {
			System.out.println("Такого варианта ответа нет. Для ответа введите число от 1 до 3.");
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
	
	private void greeting(final Person person)
	{
		
		System.out.println("Здравствуйте, " + person.toString() + "!");
		System.out.println("Ответьте, пожалуйста, на несколько вопросов. Для ответа вводите число от 1 до 3. Для выхода нажмите 0.");
	}
	
	private void sayGoodBuy()
	{
		System.out.println("Всего хорошего!");
		System.exit(0);
	}

}
