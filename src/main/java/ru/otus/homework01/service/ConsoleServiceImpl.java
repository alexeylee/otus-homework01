package ru.otus.homework01.service;

import java.util.Scanner;

//TODO переписать в пригодный для тестирования вид
public class ConsoleServiceImpl implements ConsoleService{
	
	private Scanner scanner = new Scanner(System.in);
	
	public String getAnswer(final String question) {
		
		String answer;
		System.out.print(question);
		answer = scanner.nextLine();
		return answer;
	}

	public void close() {
		this.scanner.close();
	}
}
