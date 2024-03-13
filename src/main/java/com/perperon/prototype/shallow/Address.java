package com.perperon.prototype.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dupengcheng
 * @date 2024-03-13
 * @apiNote
 */
@Data
@AllArgsConstructor
public class Address implements Cloneable{
    private String name;

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
