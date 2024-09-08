package com.banana;

import com.banana.config.SpringConfig;
import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        System.out.println("School Manager.....");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        System.out.println(context);

        StudentsRepositoryInf repoStu = context.getBean(StudentsRepository.class);
        System.out.println(repoStu.getById(1L));

        IStudentService repoServ = context.getBean(StudentsService.class);
        System.out.println(repoServ.getStudentById(2L));

    }
}
