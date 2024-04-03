package com.perperon.pattern.iterator.impl;

import com.perperon.pattern.iterator.OIterator;

import java.util.List;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote
 */
public class ConcreteIterator implements OIterator {
    private List<Object> list;
    private int currentIndex;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return list.get(currentIndex++);
        }
        return null;
    }
}
