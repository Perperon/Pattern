package com.perperon.pattern.proxy.jdk.dynamic.impl;

import com.perperon.pattern.proxy.jdk.dynamic.SmsService;

/**
 * @author dupengcheng
 * @date 2024-03-08
 * @apiNote
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
