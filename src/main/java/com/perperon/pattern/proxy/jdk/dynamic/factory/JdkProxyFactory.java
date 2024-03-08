package com.perperon.pattern.proxy.jdk.dynamic.factory;

import com.perperon.pattern.proxy.jdk.dynamic.handler.DebugInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author dupengcheng
 * @date 2024-03-08
 * @apiNote 获取代理对象的工厂类
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        //生成代理对象
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
