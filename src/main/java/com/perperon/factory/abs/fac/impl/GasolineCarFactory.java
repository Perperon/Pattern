package com.perperon.factory.abs.fac.impl;

import com.perperon.factory.abs.Battery;
import com.perperon.factory.abs.Car;
import com.perperon.factory.abs.fac.CarFactory;
import com.perperon.factory.abs.service.GasolineCar;
import com.perperon.factory.abs.service.GasolineTank;

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
