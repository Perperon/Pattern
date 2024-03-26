package com.perperon.pattern.factory.abs.fac;

import com.perperon.pattern.factory.abs.Battery;
import com.perperon.pattern.factory.abs.Car;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote 定义抽象工厂接口
 */
public interface CarFactory {
    Car createCar();
    Battery createBattery();
}
