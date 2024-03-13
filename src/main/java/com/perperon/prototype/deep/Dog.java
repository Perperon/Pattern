package com.perperon.prototype.deep;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dupengcheng
 * @date 2024-03-13
 * @apiNote
 */
@Data
@AllArgsConstructor
public class Dog implements Cloneable {
    private String name;
    public Dog clone() {
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
