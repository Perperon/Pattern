package com.perperon.pattern.single.lazy.check;

/**
 * @author perperon
 * @date 2024/3/10
 * @apiNote 懒汉式（线程安全，双重检查锁定）
 */
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
