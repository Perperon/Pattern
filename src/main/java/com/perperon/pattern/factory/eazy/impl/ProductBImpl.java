package com.perperon.pattern.factory.eazy.impl;

import com.perperon.pattern.factory.eazy.Product;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class ProductBImpl implements Product {
    @Override
    public void use() {
        System.out.println("Product B is being used.");
    }
}
