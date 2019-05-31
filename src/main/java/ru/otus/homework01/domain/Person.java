package ru.otus.homework01.domain;

public class Person {
	//TODO применить библиотеку Lombok
	private String name;
	private String patronimic;
	
	public Person(final String name, final String patronimic) {
		this.name = name;
		this.patronimic = patronimic;
	}

	public String getName() {
		return name;
	}

	public String getPatronimic() {
		return patronimic;
	}

	@Override
	public String toString() {
		return this.name + " " + this.patronimic;
	}
	
	
}
