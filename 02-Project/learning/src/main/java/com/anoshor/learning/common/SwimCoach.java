package com.anoshor.learning.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Learn BreastStroke yo";
    }
}
