package com.perperon.pattern.factory.abs.fac.impl;

import com.perperon.pattern.factory.abs.Battery;
import com.perperon.pattern.factory.abs.Car;
import com.perperon.pattern.factory.abs.fac.CarFactory;
import com.perperon.pattern.factory.abs.service.ElectricBattery;
import com.perperon.pattern.factory.abs.service.ElectricCar;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote 具体的工厂类
 */
public class ElectricCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public Battery createBattery() {
        return new ElectricBattery();
    }
}
