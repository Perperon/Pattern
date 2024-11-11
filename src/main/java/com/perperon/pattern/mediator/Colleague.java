package com.perperon.pattern.mediator;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote
 */
public interface Colleague {
    void receive(String message);
    void send(String message);
}
