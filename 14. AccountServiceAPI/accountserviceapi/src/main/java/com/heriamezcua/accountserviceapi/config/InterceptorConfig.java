package com.heriamezcua.accountserviceapi.config;

import com.heriamezcua.accountserviceapi.interceptors.AccountsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AccountsInterceptor accountsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accountsInterceptor).addPathPatterns("/api/accounts/**");
    }
}
