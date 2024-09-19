package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.banana.persistence"})
public class SpringConfig {

    @Autowired
    StudentsRepository repo;

    @Bean
    IStudentService getStudentService() {
        StudentsService studentService = new StudentsService();
        return studentService;
    }

}
