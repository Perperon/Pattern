package com.perperon.adapter.impl;

import com.perperon.adapter.Adaptee;
import com.perperon.adapter.Target;

/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote 实现适配器类
 */
public class Adapter implements Target {
    // 持有适配者的引用
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // 调用适配者的具体方法，并将其适配为目标接口的方法
        adaptee.specificRequest();
    }
}
