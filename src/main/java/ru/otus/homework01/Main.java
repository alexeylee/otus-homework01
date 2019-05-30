package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.otus.homework01.domain.Quiz;
import ru.otus.homework01.service.QuizService;




public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        
        //получить объект, содержащий загруженные из файла вопросы
        QuizService service = context.getBean(QuizService.class);
        Quiz quiz = service.getQuiz();
        
        //передать список вопросов в класс, обеспечивающий взаимодействие с пользователем
        new Console().run(quiz.getQuestions());
        
    }
}
