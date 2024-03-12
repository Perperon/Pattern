package com.perperon.factory.abs.service;

import com.perperon.factory.abs.Battery;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class GasolineTank implements Battery{

    @Override
    public void charge() {
        System.out.println("Refilling a gasoline tank.");
    }
}
