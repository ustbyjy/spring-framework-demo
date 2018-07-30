package com.yjy.test.config;

import com.yjy.test.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类等于配置文件
 */
@Configuration
@ComponentScan(value = "com.yjy.test")
//@ComponentScan(value = "com.yjy.test", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})
// 默认扫描@Component、@Repository、@Service、@Controller，若要达到只包含的效果，则设置useDefaultFilters=false来禁用默认扫描策略
//@ComponentScan(value = "com.yjy.test", useDefaultFilters = false, includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
//})
public class MainConfig {

    /**
     * bean的id方法名，或者使用@Bean注解的value属性指定
     *
     * @return
     */
    @Bean
//    @Bean(value = "person")
    public Person person01() {
        return new Person("lisi", 20);
    }

}
