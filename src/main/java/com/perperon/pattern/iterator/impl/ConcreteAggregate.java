package com.perperon.pattern.iterator.impl;

import com.perperon.pattern.iterator.Aggregate;
import com.perperon.pattern.iterator.OIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> elements;

    public ConcreteAggregate() {
        this.elements = new ArrayList<>();
    }

    public void add(Object element) {
        elements.add(element);
    }

    @Override
    public OIterator creatIterator() {
        return new ConcreteIterator(elements);
    }
}
