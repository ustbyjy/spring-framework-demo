package com.yjy.test;

import com.yjy.test.config.MainConfig;
import com.yjy.test.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");

        System.out.println(person == person2);
    }

    @Test
    public void test03() {
        System.out.println("init application context start");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("init application context end");

        System.out.println("get bean start");
        applicationContext.getBean("person01");
        System.out.println("get bean end");
    }

}
