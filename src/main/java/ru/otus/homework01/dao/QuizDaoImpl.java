package ru.otus.homework01.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import ru.otus.homework01.domain.Quiz;

/*Класс реализует загрузку данных.
 *В дальнейшем данные будут загружаться из БД*/
public class QuizDaoImpl implements QuizDao{
	
	private Quiz quiz;
	private String csvFileName;
	
	public void setFileName(String fileName) {
		
		this.csvFileName = fileName;
	}
	
	public void loadData(){
		
		List<String[]> csvLines = readCSV(this.csvFileName);
		this.quiz = new Quiz(csvLines);
	}
	
	private List<String[]> readCSV(final String fileName){
		
		InputStream stream = Quiz.class.getResourceAsStream(fileName);
		Reader reader = new InputStreamReader(stream);
		 
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> csvLines = new ArrayList<>();
		
		try {
			csvLines = csvReader.readAll();
			reader.close();
			csvReader.close();
		} catch (IOException e) {
			// TODO обработать исключение
			e.printStackTrace();
		}
		
		return csvLines;
	}

	public Quiz getQuize() {
		return quiz;
	}
	
	

}
