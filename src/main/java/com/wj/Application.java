package com.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.SpringServletContainerInitializer;

//
@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringServletContainerInitializer {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }



}
