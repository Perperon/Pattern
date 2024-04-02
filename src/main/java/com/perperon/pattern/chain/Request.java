package com.perperon.pattern.chain;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class Request {
    private String requestData;

    public Request(String requestData) {
        this.requestData = requestData;
    }

    public String getRequestData() {
        return requestData;
    }
}
