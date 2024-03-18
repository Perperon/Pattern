package com.perperon.pattern;

import com.perperon.adapter.Adaptee;
import com.perperon.adapter.Target;
import com.perperon.adapter.impl.AdapteeClass;
import com.perperon.adapter.impl.Adapter;
import com.perperon.builder.Director;
import com.perperon.builder.build.Builder;
import com.perperon.builder.build.service.ComputerBuilder;
import com.perperon.factory.abs.Battery;
import com.perperon.factory.abs.Car;
import com.perperon.factory.abs.fac.CarFactory;
import com.perperon.factory.abs.fac.impl.ElectricCarFactory;
import com.perperon.factory.abs.fac.impl.GasolineCarFactory;
import com.perperon.factory.eazy.Product;
import com.perperon.factory.eazy.fac.ProductFactory;
import com.perperon.observer.Observer;
import com.perperon.observer.concrete.ConcreteObserver;
import com.perperon.observer.concrete.ConcreteSubject;
import com.perperon.pattern.proxy.cglib.dynamic.AliSmsService;
import com.perperon.pattern.proxy.cglib.dynamic.factory.CglibProxyFactory;
import com.perperon.pattern.proxy.jdk.dynamic.SmsService;
import com.perperon.pattern.proxy.jdk.dynamic.factory.JdkProxyFactory;
import com.perperon.pattern.proxy.jdk.dynamic.impl.SmsServiceImpl;
import com.perperon.pattern.proxy.state.proxy.SmsProxy;
import com.perperon.prototype.deep.Animal;
import com.perperon.prototype.deep.Dog;
import com.perperon.prototype.shallow.Address;
import com.perperon.prototype.shallow.Person;
import com.perperon.thread.ThreadLocalExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class PatternApplicationTests {

    // 创建ThreadLocal实例
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    /**
     *静态代理
     */
    @Test
    public void test1(){
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("静态代理");
    }
    /**
     * jdk动态代理测试
     */
    @Test
    public void test2() {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("Hello World【JDK动态代理】");
    }

    /**
     * cglib动态代理测试
     */
    @Test
    public void test3() {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("Hello World【cglib动态代理】");
    }

    /**
     * 观察者模式测试
     */
    @Test
    public void test4(){
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        subject.notifyObservers("Hello, observers!");

        subject.removeObserver(observer2);

        subject.notifyObservers("Hello again!");
    }

    /**
     * 简单工厂设计模式测试
     */
    @Test
    public void test5() {
        Product productA = ProductFactory.createProduct("A");
        if (productA != null) {
            productA.use();
        }

        Product productB = ProductFactory.createProduct("B");
        if (productB != null) {
            productB.use();
        }
    }

    /**
     * 抽象工厂设计模式测试
     */
    @Test
    public void test6() {
        // 创建电动车工厂
        CarFactory electricCarFactory = new ElectricCarFactory();

        // 使用电动车工厂创建电动车和电池
        Car electricCar = electricCarFactory.createCar();
        Battery electricBattery = electricCarFactory.createBattery();

        electricCar.drive();
        electricBattery.charge();

        // 创建汽油车工厂
        CarFactory gasolineCarFactory = new GasolineCarFactory();

        // 使用汽油车工厂创建汽油车和油箱
        Car gasolineCar = gasolineCarFactory.createCar();
        Battery gasolineTank = gasolineCarFactory.createBattery();

        gasolineCar.drive();
        gasolineTank.charge();
    }

    /**
     * 建造者模式测试
     */
    @Test
    public void test7() {
        // 创建Builder对象
        Builder builder = new ComputerBuilder();
        // 创建Director对象，并将Builder对象传入
        Director director = new Director(builder);

        // 调用Director对象的constructProduct方法，开始构建产品
        director.constructProduct();
    }

    /**
     * 原型模式
     */
    @Test
    public void test9(){
        //浅拷贝
        Person person = new Person(new Address("张三"));
        Person personCopy = person.clone();
        System.out.println(person.getAddress());
        System.out.println(personCopy.getAddress());
        System.out.println(person.getAddress()==personCopy.getAddress());

        //深拷贝
        Animal animal = new Animal(new Dog("旺财"));
        Animal animalClone = animal.clone();
        System.out.println(animal.getDog());
        System.out.println(animalClone.getDog());
        System.out.println(animal.getDog() == animalClone.getDog());

    }

    /**
     * ThreadLocal是Java中的一个类，它提供了线程局部变量。这些变量与其他普通变量的区别在于，
     * 每一个访问该变量的线程都会有自己独立、初始化的变量副本。ThreadLocal变量通常用于保存用户的会话信息，
     * 因为Web应用是基于多线程的，不同的线程可能会同时处理同一个用户的不同请求，因此不能使用全局变量来保存每个用户的会话信息，
     * 而ThreadLocal就可以为每个线程提供一个独立的变量副本，从而避免数据混乱。
     *
     *简单的ThreadLocal使用示例，演示了如何在多线程环境中为每个线程保存独立的变量值
     */
    @Test
    public void test8() throws InterruptedException {
       /* // 创建并启动线程1
        Thread thread1 = new Thread(() -> {
            // 为线程1设置值
            threadLocal.set(1);
            try {
                Thread.sleep(1000); // 假设线程1做一些工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取并打印线程1的值
            System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get());
        });

        // 创建并启动线程2
        Thread thread2 = new Thread(() -> {
            // 为线程2设置值
            threadLocal.set(2);
            try {
                Thread.sleep(1000); // 假设线程2做一些工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 获取并打印线程2的值
            System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get());
        });

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 移除ThreadLocal中的值，避免内存泄漏
        threadLocal.remove();*/
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Test
    public void test10() {
        // 创建适配者对象
        Adaptee adaptee = new AdapteeClass();
        // 创建适配器对象，传入适配者对象
        Target target = new Adapter(adaptee);
        // 客户端通过目标接口调用方法
        target.request();
    }
}
