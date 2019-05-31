package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.otus.homework01.domain.Person;
import ru.otus.homework01.domain.Quiz;
import ru.otus.homework01.service.InteractService;
import ru.otus.homework01.service.LoginService;
import ru.otus.homework01.service.QuizService;




public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        
        /*LoginService loginService = context.getBean(LoginService.class);
        QuizService service = context.getBean(QuizService.class);
        
        Person p = loginService.getPerson();
      //получить объект, содержащий загруженные из файла вопросы
        Quiz quiz = service.getQuiz();
        
        //передать список вопросов в класс, обеспечивающий взаимодействие с пользователем
        //new Console().run(quiz.getQuestions());*/
        
        InteractService runner = context.getBean(InteractService.class);
        runner.run();
        
    }
}
