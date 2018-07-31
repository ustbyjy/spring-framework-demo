package com.yjy.test;

import com.yjy.test.bean.Boss;
import com.yjy.test.bean.Car;
import com.yjy.test.bean.Color;
import com.yjy.test.bean.Person;
import com.yjy.test.config.*;
import com.yjy.test.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

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

    @Test
    public void test04() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        String osName = applicationContext.getEnvironment().getProperty("os.name");
        System.out.println(osName);

        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Person.class);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testImport() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testFactoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 获取工厂bean创建的对象
        Object bean = applicationContext.getBean("colorFactoryBean");
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println(bean.getClass());
        System.out.println(bean == bean2);

        // 加前缀&，获取工厂bean本身
        Object factoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(factoryBean.getClass());
    }

    @Test
    public void testLifeCycle() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        ((AnnotationConfigApplicationContext) applicationContext).close();
    }

    @Test
    public void testPropertyValue() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("===================================");

        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("person.nickName"));
    }

    @Test
    public void testAutowired() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);
    }

    @Test
    public void testAutowired2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        System.out.println("=============================================================");

        Boss boos = applicationContext.getBean(Boss.class);
        System.out.println(boos);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
    }

}
