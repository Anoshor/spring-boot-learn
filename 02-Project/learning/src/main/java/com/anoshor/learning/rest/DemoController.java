package com.anoshor.learning.rest;

import com.anoshor.learning.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define private
    private Coach myCoach;
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach coach) {
        myCoach = coach;
//        anotherCoach = coach2;
    }

    //optional setter injection - previous one is called constructor injection

//    @Autowired
//    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing Beans: " + (myCoach == anotherCoach);
//    }
}
