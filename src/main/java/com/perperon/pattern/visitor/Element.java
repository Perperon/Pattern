package com.perperon.pattern.visitor;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote 被访问者接口
 */
public interface Element {
    void accept(Visitor visitor);
}
