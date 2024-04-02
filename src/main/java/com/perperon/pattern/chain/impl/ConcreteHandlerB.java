package com.perperon.pattern.chain.impl;

import com.perperon.pattern.chain.ChainHandler;
import com.perperon.pattern.chain.Request;
import com.perperon.pattern.chain.Response;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class ConcreteHandlerB implements ChainHandler {
    private ChainHandler successor;

    public ConcreteHandlerB(ChainHandler successor) {
        this.successor = successor;
    }

    @Override
    public Response handleRequest(Request request) {
        if ("B".equals(request.getRequestData())) {
            return new Response("Handled by ConcreteHandlerB");
        } else if (successor != null) {
            return successor.handleRequest(request);
        }
        return new Response("Unhandled request");
    }
}
