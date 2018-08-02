package com.yjy.test.ext;

import com.yjy.test.bean.Blue;
import com.yjy.test.bean.Person;
import org.springframework.beans.factory.config.PropertyOverrideConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * BeanFactoryPostProcessor: BeanFactory的后置处理器，在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到BeanFactory，但是bean的实例还未创建<br>
 * BeanDefinitionRegistryPostProcessor: 在所有bean定义信息将要被加载，bean的实例还未创建，优先于BeanFactoryPostProcessor执行<br>
 */
@ComponentScan("com.yjy.test.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }

    @Bean
    public PropertyOverrideConfigurer propertyOverrideConfigurer() {
        PropertyOverrideConfigurer propertyOverrideConfigurer = new PropertyOverrideConfigurer();
        Resource resource = new ClassPathResource("person.properties");
        propertyOverrideConfigurer.setLocation(resource);

        return propertyOverrideConfigurer;
    }

    @Bean
    public Person person() {
        return new Person();
    }
}
