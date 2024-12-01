package com.anoshor.learning.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("Hey, I'm " + getClass().getSimpleName());
    }

    //defione init method and destroy method


//    @PostConstruct
//    public void StartUp() {
//        System.out.println("In StartUp() " + getClass().getSimpleName());
//    }
//    @PreDestroy
//    public void CleanUp() {
//        System.out.println("In CleanUp() " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice Free Kicks for 45mins";
    }
}
