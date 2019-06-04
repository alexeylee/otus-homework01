package ru.otus.homework01.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import ru.otus.homework01.domain.Quiz;
import ru.otus.homework01.exceptions.ApplicationException;

public class QuizDaoImpl implements QuizDao{
	
	private Quiz quiz;
	
	public QuizDaoImpl(final String fileName) throws ApplicationException {
		loadData(fileName);
	}

	private void loadData(final String fileName) throws ApplicationException{
		
		List<String[]> csvLines = readCSV(fileName);
		this.quiz = new Quiz(csvLines);
	}
	
	private List<String[]> readCSV(final String fileName) throws ApplicationException{
		
		InputStream stream = Quiz.class.getResourceAsStream(fileName);
		if (stream == null)
			throw new ApplicationException(
				"Возникла ошибка при загрузке файла CSV. Файл " + fileName + " не найден."
			);
		
		Reader reader = new InputStreamReader(stream);
		 
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> csvLines = new ArrayList<>();
		
		try {
			csvLines = csvReader.readAll();
			reader.close();
			csvReader.close();
		} catch (IOException e) {
			throw new ApplicationException(
				"Возникла ошибка при загрузке файла CSV. Текст ошибки: " + e.getMessage()
			);
		}
		
		return csvLines;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}
	
	

}
