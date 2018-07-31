package com.yjy.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@code @Autowired}位置: 1.setter方法; 2.构造器; 3.参数列表;
 */
@Component
public class Boss {
    private Car car;

    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Boss{");
        sb.append("car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
