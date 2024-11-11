package com.perperon.pattern.decorator.dec;

import com.perperon.pattern.decorator.Coffee;
import com.perperon.pattern.decorator.CoffeeDecorator;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote 装饰器类
 */
public class Milk implements CoffeeDecorator{
    private Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + ", Milk";
    }
}
