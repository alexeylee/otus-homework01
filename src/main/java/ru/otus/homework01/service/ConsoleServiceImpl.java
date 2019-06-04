package ru.otus.homework01.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService{
	
	private Scanner scanner;
	private PrintStream printer;
	
	public ConsoleServiceImpl(InputStream in, PrintStream out) {
		this.scanner = new Scanner(in);
		this.printer = out;
	}
	
	public String getAnswer(final String question) {
		print(question);
		return scanner.nextLine();
	}

	public void print(String message) {
		this.printer.print(message);
	}
}
