package com.perperon.builder.impl;

import com.perperon.builder.Product;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class Computer implements Product {
    private String partA;
    private String partB;
    private String partC;
    @Override
    public void setPartA() {
        this.partA = "Part A";
    }

    @Override
    public void setPartB() {
        this.partB = "Part B";
    }

    @Override
    public void setPartC() {
        this.partC = "Part C";
    }

    @Override
    public void showProduct() {
        System.out.println("Computer is built with parts: " + partA + ", " + partB + ", " + partC);
    }
}
