package ru.otus.homework01.service;

import ru.otus.homework01.dao.QuizDao;
import ru.otus.homework01.domain.Quiz;

public class QuizServiceImpl implements QuizService{

	private QuizDao dao;
	
	public QuizServiceImpl(QuizDao dao) {
		this.dao = dao;
		dao.loadData();
	}
	
	public Quiz getQuiz() {
		return dao.getQuize();
	}
}
