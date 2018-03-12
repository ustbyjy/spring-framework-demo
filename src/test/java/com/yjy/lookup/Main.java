package com.yjy.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lookup/lookupTest.xml");
        GetBeanTest test = (GetBeanTest) applicationContext.getBean("getBeanTest");
        test.showMe();
    }
}
