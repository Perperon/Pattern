package com.perperon.pattern.composite.impl;

import com.perperon.pattern.composite.Component;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote
 */
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Composite: " + name + ". Operation()");
        for (Component child : children) {
            child.operation();
        }
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }
}
