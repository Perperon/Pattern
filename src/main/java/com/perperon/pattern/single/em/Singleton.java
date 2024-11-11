package com.perperon.pattern.single.em;

/**
 * @author perperon
 * @date 2024/3/10
 * @apiNoteSingletonEnum 是一个枚举类型，它只有一个枚举常量 INSTANCE。由于枚举常量的唯一性，这个枚举类型自动就是单例的。要访问这个单例，我们只需要调用 SingletonEnum.INSTANCE。
 */
public enum Singleton {
    INSTANCE;
    public void doSomething() {
        // 单例的业务逻辑
        System.out.println("SingletonEnum is doing something.");
    }
}
