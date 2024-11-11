package com.perperon.pattern.decorator.impl;

import com.perperon.pattern.decorator.Coffee;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public String getIngredients() {
        return "Coffee";
    }
}
