package com.yjy.test.config;


import com.yjy.test.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.yjy.test.bean")
@Configuration
public class MainConfigOfLifeCycle {

    /**
     * 多实例: 容易不会管理创建的bean，容器也不会调用销毁方法
     *
     * @return
     */
    //    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
