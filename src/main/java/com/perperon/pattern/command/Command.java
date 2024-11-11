package com.perperon.pattern.command;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote 命令模式
 */
public interface Command {
    void execute();
    void undo();
}
