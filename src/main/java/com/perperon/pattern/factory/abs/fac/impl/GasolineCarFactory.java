package com.perperon.pattern.factory.abs.fac.impl;

import com.perperon.pattern.factory.abs.Battery;
import com.perperon.pattern.factory.abs.Car;
import com.perperon.pattern.factory.abs.fac.CarFactory;
import com.perperon.pattern.factory.abs.service.GasolineCar;
import com.perperon.pattern.factory.abs.service.GasolineTank;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote 具体的工厂类
 */
public class GasolineCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new GasolineCar();
    }

    @Override
    public Battery createBattery() {
        return new GasolineTank();
    }
}
