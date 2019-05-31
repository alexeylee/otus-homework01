package ru.otus.homework01.service;

import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService{
	
	private Scanner scanner = new Scanner(System.in);
	
	public String getAnswer(String question) {
		
		String answer;
		System.out.print(question);
		answer = scanner.nextLine();

		return answer;
	}

	public void close() {

		this.scanner.close();
	}
}
