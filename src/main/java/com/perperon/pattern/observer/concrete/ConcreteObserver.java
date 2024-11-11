package com.perperon.pattern.observer.concrete;

import com.perperon.pattern.observer.Observer;

/**
 * @author dupengcheng
 * @date 2024-03-11
 * @apiNote 具体观察者类
 */
public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
