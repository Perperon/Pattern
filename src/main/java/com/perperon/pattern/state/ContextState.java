package com.perperon.pattern.state;

/**
 * @author dupengcheng
 * @date 2024-04-07
 * @apiNote
 */
public class ContextState {
    private State state;

    public ContextState(State state) {
        this.state = state;
    }

        public void setState(Class<? extends State> stateClass) {
            try {
                // 通过反射创建stateClass对应的实例，并赋值给this.state
                this.state = stateClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                // 如果创建实例过程中发生异常，则抛出运行时异常，并将原异常作为运行时异常的cause
                throw new RuntimeException(e);
            }
        }


    public void request() {
        state.handle(this);
    }
}
