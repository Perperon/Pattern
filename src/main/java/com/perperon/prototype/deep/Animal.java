package com.perperon.prototype.deep;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dupengcheng
 * @date 2024-03-13
 * @apiNote 原型模式-深克隆
 */
@Data
@AllArgsConstructor
public class Animal implements Cloneable{
    private Dog dog;
    @Override
    public Animal clone() {
        try {
            Animal animal = (Animal) super.clone();
            animal.dog = dog.clone();
            return animal;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
