package ru.otus.homework01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Question {
	private @Getter String id;
	private @Getter String questionText;
	private @Getter String correctAnswerId;
}
