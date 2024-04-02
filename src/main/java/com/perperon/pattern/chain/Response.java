package com.perperon.pattern.chain;

/**
 * @author dupengcheng
 * @date 2024-04-02
 * @apiNote
 */
public class Response {
    private String responseData;

    public Response(String responseData) {
        this.responseData = responseData;
    }

    public String getResponseData() {
        return responseData;
    }
}