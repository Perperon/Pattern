package com.perperon.pattern.mediator.impl;

import com.perperon.pattern.mediator.Colleague;
import com.perperon.pattern.mediator.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote
 */
public class ConcreteMediator implements Mediator {

    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void registerColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void relay(String message) {
        for (Colleague colleague : colleagues) {
            colleague.receive(message);
        }
    }
}
