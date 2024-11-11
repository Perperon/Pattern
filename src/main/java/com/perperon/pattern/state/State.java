package com.perperon.pattern.state;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote 状态模式
 */
public interface State {
    void handle(ContextState context);
}
