package com.perperon.pattern.builder.build;

import com.perperon.pattern.builder.Product;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote Builder接口
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();

    Product getProduct();
}
