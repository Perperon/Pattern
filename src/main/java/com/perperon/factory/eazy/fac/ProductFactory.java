package com.perperon.factory.eazy.fac;

import com.perperon.factory.eazy.Product;
import com.perperon.factory.eazy.impl.ProductAImpl;
import com.perperon.factory.eazy.impl.ProductBImpl;

/**
 * @author dupengcheng
 * @date 2024-03-12
 * @apiNote
 */
public class ProductFactory {
    public static Product createProduct(String type) {
        // 如果传入的类型为空，则返回null
        if (type == null) {
            return null;
        }
        // 如果传入的类型等于"A"（不区分大小写），则返回ProductAImpl的实例
        if (type.equalsIgnoreCase("A")) {
            return new ProductAImpl();
        } else if (type.equalsIgnoreCase("B")) {
            // 如果传入的类型等于"B"（不区分大小写），则返回ProductBImpl的实例
            return new ProductBImpl();
          }
        // 如果传入的类型既不是"A"也不是"B"，则返回null
        return null;
    }

}
