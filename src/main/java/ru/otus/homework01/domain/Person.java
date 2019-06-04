package ru.otus.homework01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Person {
	
	private @Getter String name;
	private @Getter String patronimic;

	@Override
	public String toString() {
		return this.name + " " + this.patronimic;
	}	
}
