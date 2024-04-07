package com.perperon.pattern.template;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote 模板方法模式
 */
public abstract class TemplateClass {
    // 模板方法
    public final void templateMethod() {
        System.out.println("执行算法的第一步...");
        specificStepA(); // 调用抽象方法，由子类实现
        System.out.println("执行算法的第二步...");
        specificStepB(); // 调用抽象方法，由子类实现
        System.out.println("执行算法的第三步...");
    }

    // 抽象方法，由子类实现
    protected abstract void specificStepA();
    protected abstract void specificStepB();
}
