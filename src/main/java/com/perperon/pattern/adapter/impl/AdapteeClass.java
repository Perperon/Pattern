package com.perperon.pattern.adapter.impl;

import com.perperon.pattern.adapter.Adaptee;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote 适配者接口的具体类
 */
public class AdapteeClass implements Adaptee {
    @Override
    public void specificRequest() {
        System.out.println("AdapteeClass specificRequest()");
    }
}
