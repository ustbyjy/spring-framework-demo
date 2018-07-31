package com.yjy.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:/db.properties")
@Configuration
public class MainConfigOfProfile {

    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.driverClass}")
    private String driverClass;

    @Profile("test")
    @Bean
    public DataSource dataSourceTest() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://vhost2:3306/test");

        return dataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://vhost2:3306/dev");

        return dataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourceProd() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl("jdbc:mysql://vhost2:3306/prod");

        return dataSource;
    }

}
