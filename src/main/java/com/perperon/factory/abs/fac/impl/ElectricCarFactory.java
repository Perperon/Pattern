package com.perperon.factory.abs.fac.impl;

import com.perperon.factory.abs.Battery;
import com.perperon.factory.abs.Car;
import com.perperon.factory.abs.fac.CarFactory;
import com.perperon.factory.abs.service.ElectricBattery;
import com.perperon.factory.abs.service.ElectricCar;

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
