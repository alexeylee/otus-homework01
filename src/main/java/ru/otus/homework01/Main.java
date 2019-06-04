package ru.otus.homework01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework01.service.InteractService;

public class Main {

    public static void main(String[] args) {
    	
    	try {
    		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    		InteractService runner = context.getBean(InteractService.class);
    	    runner.run();
    	}catch (Exception e) {
    		System.err.print(e.getMessage());
    	}
    }
}
