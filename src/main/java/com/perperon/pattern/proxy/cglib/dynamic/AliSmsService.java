package com.perperon.pattern.proxy.cglib.dynamic;

/**
 * @author dupengcheng
 * @date 2024-03-08
 * @apiNote
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
