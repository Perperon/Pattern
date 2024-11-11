package com.perperon.pattern.bridge;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote 定义抽象化角色的类，包含一个对实现类角色的引用
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    public Shape(DrawAPI drawApi) {
        this.drawAPI = drawApi;
    }

    public abstract void draw();
}
