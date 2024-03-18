package com.perperon.fly.impl;

import com.perperon.fly.Flyweight;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState; // 内部状态

    public ConcreteFlyweight(String state) {
        this.intrinsicState = state;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic state: " + intrinsicState);
        System.out.println("Extrinsic state: " + extrinsicState);
    }
}
