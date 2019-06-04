package ru.otus.homework01.service;

import ru.otus.homework01.domain.Person;

public class LoginServiceImpl implements LoginService{
	
	private ConsoleService console;
	
	public LoginServiceImpl (ConsoleService console) {
		this.console = console;
	}
	
	public Person getPerson() {	
		return loginUser();
	}
	
	private Person loginUser() {
		
		String name = "";
		String patronimic = "";
		
		name = getInput("Ваше имя: ");
		patronimic = getInput("Ваше отчество: ");
		
		return new Person(name, patronimic);
	}
	
	private String getInput(final String question) {
		
		String line;
		while (true) {
			line = console.getAnswer(question);
			
			if (isAnswerValid(line))
				break;
		}
		return line;
	}
	
	private boolean isAnswerValid(final String answer) {
		
		if (answer == null || answer.isEmpty()) {
			console.print("Этот параметр обязателен!");
			return false;
		}
		return true;	
	}
}
