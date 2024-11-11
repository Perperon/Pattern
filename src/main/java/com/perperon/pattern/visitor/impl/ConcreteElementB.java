package com.perperon.pattern.visitor.impl;

import com.perperon.pattern.visitor.Element;
import com.perperon.pattern.visitor.Visitor;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    // ... ConcreteElementB的其他方法和属性
}