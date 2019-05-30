package ru.otus.homework01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import ru.otus.homework01.domain.Question;

//TODO Вынести получение имени и фамилии в отдельный сервис. Не запускать тест, пока не введут
//TODO Приветствовать по имени и фамилии. В Результат так же писать имя и фамилию
public class Console {
	
	private Scanner scanner = new Scanner(System.in);
	private int correctAnswers = 0;
	
	public void run(HashMap<String, Question> questions) {
		greeting();
		processDialog(questions);
		processResult(questions.size());
	}
	
	private void greeting()	{
		String name;
		System.out.print("Введите Ваше имя: ");
		name = scanner.nextLine();
		System.out.println(
			"Здравствуйте, " + name + "!\n" + 
			"Ответьте, пожалуйста, на несколько вопросов. Для ответа вводите число от 1 до 3. Для выхода нажмите 0.");
	}
	
	private void processDialog(HashMap<String, Question> questions) {
		int answer = 0;
		Question question;
		
		Iterator it = questions.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			question = (Question)entry.getValue();
			
			answer = getAnswer(question);
			
			if (answer == 0) {
				System.out.println("Всего хорошего!");
				System.exit(0);
			}
				
			if (answer == question.getCorrectAnswerId()) {
				System.out.println("Правильно!");
				correctAnswers++;
			}
			else {
				System.out.println("Это неправильный ответ! Продолжаем ...");
			}
		}
	}
	
	private void processResult(int questionsQuantity){
		System.out.println("Вы ответили правильно на " + correctAnswers + " вопросов из " + questionsQuantity + ". До свидания!");
		System.exit(0);
	}
	
	private int getAnswer(Question question) {
		int answer = 0;
		String line;
		System.out.println("Вопрос " + question.getId() + ". " + question.getQuestionText() + ":  ");

		while (true) {
			line = scanner.nextLine();
			try {
				answer = Integer.valueOf(line);
				if (isAnswerValid(answer))
					break;
				else
					System.out.println("Такого варианта ответа нет. Для ответа введите число от 1 до 3:  ");

			} catch (NumberFormatException e) {
				System.out.println("Такого варианта ответа нет. Для ответа введите число от 1 до 3:  ");
            }
		}
		return answer;
	}

	private boolean isAnswerValid(int answer)
	{
		if (answer < 0 || answer >3)
			return false;
		
		return true;
	}
}
