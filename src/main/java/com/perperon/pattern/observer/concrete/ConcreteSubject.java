package com.perperon.pattern.observer.concrete;

import com.perperon.pattern.observer.Observer;
import com.perperon.pattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dupengcheng
 * @date 2024-03-11
 * @apiNote 具体主题类
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
