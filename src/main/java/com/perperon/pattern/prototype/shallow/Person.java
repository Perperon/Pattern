package com.perperon.pattern.prototype.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dupengcheng
 * @date 2024-03-13
 * @apiNote 原型模式-浅拷贝
 */
@Data
@AllArgsConstructor
public class Person implements Cloneable {
    private Address address;

    public Person clone()  {
        try {
            return (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
