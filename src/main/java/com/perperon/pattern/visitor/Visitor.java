package com.perperon.pattern.visitor;

import com.perperon.pattern.visitor.impl.ConcreteElementA;
import com.perperon.pattern.visitor.impl.ConcreteElementB;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote 访问者接口
 */
public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
