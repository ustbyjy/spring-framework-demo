package com.yjy.test.config;

import com.yjy.test.bean.Car;
import com.yjy.test.bean.Color;
import com.yjy.test.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.yjy.test.dao", "com.yjy.test.service", "com.yjy.test.controller", "com.yjy.test.bean"})
public class MainConfigOfAutowired {

    @Primary
    @Bean(value = "bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }

}
