package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-prod.properties")
public class ServiConfig {

    @Autowired
    StudentsRepository repo;

    @Bean
    IStudentService getStudentService() {
        StudentsService studentService = new StudentsService();
        studentService.setRepository(repo);
        return studentService;
    }
}
