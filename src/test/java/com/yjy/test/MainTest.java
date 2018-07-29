package com.yjy.test;

import com.yjy.test.bean.Person;
import com.yjy.test.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
//        fileType();

        classType();
    }

    private static void fileType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    private static void classType() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String beanName : beanNamesForType) {
            System.out.println(beanName);
        }
    }
}
