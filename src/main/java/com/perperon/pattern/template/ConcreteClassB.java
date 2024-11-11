package com.perperon.pattern.template;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class ConcreteClassB extends TemplateClass{

    @Override
    protected void specificStepA() {
        System.out.println("具体实现B的第一步...");
    }

    @Override
    protected void specificStepB() {
        System.out.println("具体实现B的第二步...");
    }
}
