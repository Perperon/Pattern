package com.perperon.pattern.mediator.impl;

import com.perperon.pattern.mediator.Colleague;
import com.perperon.pattern.mediator.Mediator;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote
 */
public class ConcreteColleague implements Colleague {
    private Mediator mediator;
    private String name;

    public ConcreteColleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.registerColleague(this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received: " + message);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sent: " + message);
        mediator.relay(message);
    }
}
