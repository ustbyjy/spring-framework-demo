package com.yjy.test.config;

import com.yjy.test.bean.Person;
import com.yjy.test.condition.LinuxCondition;
import com.yjy.test.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig2 {

    /**
     * <p>prototype: 多实例，创建上下文时不会初始化，每次调用时都会初始化；</p>
     * <p>singleton: 单例，创建上下文时会初始化，此后调用则不会，可以使用懒加载在第一次调用时初始化。</p>
     *
     * @return
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(value = "person")
    public Person person() {
        System.out.println("person()");
        return new Person("张三", 25);
    }

    @Lazy
    @Bean
    public Person person01() {
        System.out.println("person01()");
        return new Person("王五", 40);
    }

    @Conditional(value = {WindowsCondition.class})
    @Bean(value = "bill")
    public Person person02() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean(value = "linus")
    public Person person03() {
        return new Person("Linus", 48);
    }

}
