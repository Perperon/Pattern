package com.perperon.pattern.composite.impl;

import com.perperon.pattern.composite.Component;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name + ". Operation()");
    }
}
