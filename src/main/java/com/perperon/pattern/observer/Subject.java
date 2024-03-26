package com.perperon.pattern.observer;

/**
 * @author dupengcheng
 * @date 2024-03-11
 * @apiNote 主题接口
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
