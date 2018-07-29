package com.yjy.test.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lookup/lookupTest.xml");
        GetBean test = (GetBean) applicationContext.getBean("getBeans");
        test.showMe();
    }
}
