package com.yjy.test.config;

import com.yjy.test.aop.LogAspects;
import com.yjy.test.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
