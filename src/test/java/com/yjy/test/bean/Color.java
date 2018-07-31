package com.yjy.test.bean;

public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Color{");
        sb.append("car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
