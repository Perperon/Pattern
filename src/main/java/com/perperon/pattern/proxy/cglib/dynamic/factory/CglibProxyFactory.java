package com.perperon.pattern.proxy.cglib.dynamic.factory;

import com.perperon.pattern.proxy.cglib.dynamic.interceptor.DebugMethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author dupengcheng
 * @date 2024-03-08
 * @apiNote 获取代理类
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
