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
		
		name = console.getAnswer("Ваше имя: ");
		patronimic = console.getAnswer("Ваше отчество: ");
		
		return new Person(name, patronimic);
	}

}
