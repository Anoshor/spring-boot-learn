package com.anoshor.learning.common;

import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice Backhand smash!!";
    }
}
