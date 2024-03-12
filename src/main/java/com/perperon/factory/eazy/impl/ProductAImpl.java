package com.perperon.factory.eazy.impl;

import com.perperon.factory.eazy.Product;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class ProductAImpl implements Product {
    @Override
    public void use() {
        System.out.println("Product A is being used.");
    }
}
