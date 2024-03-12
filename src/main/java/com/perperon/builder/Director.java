package com.perperon.builder;

import com.perperon.builder.build.Builder;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote Director类来指导Builder构建产品
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void constructProduct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();

        Product product = builder.getProduct();
        product.showProduct();
    }
}
