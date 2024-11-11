package com.perperon.pattern.memento;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class Originator {
    private String state; // Originator的内部状态

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // 创建备忘录
    public Memento createMemento() {
        return new Memento(state);
    }

    // 恢复状态
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }
}
