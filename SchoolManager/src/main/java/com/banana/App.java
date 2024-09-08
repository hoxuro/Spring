package com.banana;

import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        System.out.println("School Manager.....");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        IStudentService repoServ = context.getBean(StudentsService.class);
        System.out.println(repoServ);
        System.out.println(repoServ.getStudentById(2L));

    }
}
