package com.perperon.pattern.factory.abs.service;

import com.perperon.pattern.factory.abs.Car;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class GasolineCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a gasoline car.");
    }
}
