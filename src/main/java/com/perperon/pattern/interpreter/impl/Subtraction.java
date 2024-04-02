package com.perperon.pattern.interpreter.impl;

import com.perperon.pattern.interpreter.Expression;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class Subtraction implements Expression {
    private final Expression left;
    private final Expression right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}
