package com.perperon.pattern.mediator;

/**
 * @author dupengcheng
 * @date 2024-04-03
 * @apiNote 中介者模式
 */
public interface Mediator {
    void registerColleague(Colleague colleague);
    void relay(String message);
}
