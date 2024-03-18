package com.perperon.fly.factory;

import cn.hutool.core.util.ObjectUtil;
import com.perperon.fly.Flyweight;
import com.perperon.fly.impl.ConcreteFlyweight;

import java.util.HashMap;
import java.util.Map;
/**
 * @author dupengcheng
 * @date 2024-03-18
 * @apiNote 享元工厂类
 */
public class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);
        if (ObjectUtil.isEmpty(flyweight)) {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}
