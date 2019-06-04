package ru.otus.homework01.exceptions;

public class ApplicationException extends Exception{
	
	public ApplicationException(String description) {
		super();
		this.description = description;
	}
	String description;
}
