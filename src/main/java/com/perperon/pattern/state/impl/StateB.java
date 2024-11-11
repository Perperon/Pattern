package com.perperon.pattern.state.impl;

import com.perperon.pattern.state.ContextState;
import com.perperon.pattern.state.State;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class StateB implements State {
    @Override
    public void handle(ContextState context) {
        System.out.println("处理B状态的业务逻辑...");
        context.setState(StateA.class); // 转换到下一个状态
    }
}
