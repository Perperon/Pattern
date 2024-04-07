package com.perperon.pattern.memento;

import java.util.Stack;
/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class Caretaker {
    private Stack<Memento> mementos = new Stack<>();

    // 保存备忘录
    public void addMemento(Memento memento) {
        mementos.push(memento);
    }

    // 获取备忘录
    public Memento getMemento() {
        return mementos.pop();
    }
}