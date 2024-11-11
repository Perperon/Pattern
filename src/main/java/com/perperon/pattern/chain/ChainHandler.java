package com.perperon.pattern.chain;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote 责任链模式
 */
public interface ChainHandler {
    Response handleRequest(Request request);
}
