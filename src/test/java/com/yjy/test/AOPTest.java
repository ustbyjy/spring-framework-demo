package com.yjy.test;

import com.yjy.test.aop.MathCalculator;
import com.yjy.test.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(10, 2);
//        mathCalculator.div(10, 0);
    }
}
