package com.perperon.pattern.strategy;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class ContextStrategy {
    private Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
