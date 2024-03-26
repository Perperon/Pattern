package com.perperon.pattern.factory.abs.service;

import com.perperon.pattern.factory.abs.Battery;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class ElectricBattery implements Battery {

    @Override
    public void charge() {
        System.out.println("Charging an electric battery.");
    }
}
