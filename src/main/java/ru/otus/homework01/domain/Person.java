package ru.otus.homework01.domain;

public class Person {
	
	private String name;
	private String patronimic;
	
	public Person(String name, String patronimic) {
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
