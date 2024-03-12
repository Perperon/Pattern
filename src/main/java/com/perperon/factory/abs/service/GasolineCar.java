package com.perperon.factory.abs.service;

import com.perperon.factory.abs.Car;

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
