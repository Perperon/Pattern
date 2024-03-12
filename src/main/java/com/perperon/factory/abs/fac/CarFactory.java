package com.perperon.factory.abs.fac;

import com.perperon.factory.abs.Battery;
import com.perperon.factory.abs.Car;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote 定义抽象工厂接口
 */
public interface CarFactory {
    Car createCar();
    Battery createBattery();
}
