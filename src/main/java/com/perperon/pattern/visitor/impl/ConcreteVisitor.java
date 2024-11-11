package com.perperon.pattern.visitor.impl;

import com.perperon.pattern.visitor.Visitor;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("Visitor visited ConcreteElementA");
        // 对ConcreteElementA执行相应的操作
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("Visitor visited ConcreteElementB");
        // 对ConcreteElementB执行相应的操作
    }
}