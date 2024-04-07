package com.perperon.pattern.strategy.impl;

import com.perperon.pattern.strategy.Strategy;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
