package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@Import({RepoConfig.class, ServiConfig.class, ConfigDev.class, ConfigProd.class})
public class SpringConfig {


}
