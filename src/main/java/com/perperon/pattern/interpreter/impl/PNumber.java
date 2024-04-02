package com.perperon.pattern.interpreter.impl;

import com.perperon.pattern.interpreter.Expression;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class PNumber implements Expression {
    private final int value;

    public PNumber(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
