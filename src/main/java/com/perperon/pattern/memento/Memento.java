package com.perperon.pattern.memento;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote 备忘录模式
 */
public class Memento {
    private String state; // 假设Originator只有一个状态需要保存

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
