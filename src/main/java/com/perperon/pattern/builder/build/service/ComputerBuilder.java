package com.perperon.pattern.builder.build.service;

import com.perperon.pattern.builder.Product;
import com.perperon.pattern.builder.build.Builder;
import com.perperon.pattern.builder.impl.Computer;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote 它的具体实现ComputerBuilder
 */
public class ComputerBuilder implements Builder {
    private Product computer;

    public ComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildPartA() {
        computer.setPartA();
    }

    @Override
    public void buildPartB() {
        computer.setPartB();
    }

    @Override
    public void buildPartC() {
        computer.setPartC();
    }

    @Override
    public Product getProduct() {
        return computer;
    }
}
