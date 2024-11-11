package com.perperon.pattern.command.impl;

import com.perperon.pattern.command.Command;
import com.perperon.pattern.command.Receiver;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void undo() {
        // 可能的撤销操作
    }
}
