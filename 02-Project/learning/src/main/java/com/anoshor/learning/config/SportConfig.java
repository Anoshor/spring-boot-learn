package com.anoshor.learning.config;

import com.anoshor.learning.common.Coach;
import com.anoshor.learning.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() { //this will become my spring id without specifically specifying any bean id
        return new SwimCoach();
    }
}
