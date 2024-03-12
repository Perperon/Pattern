package com.perperon.pattern;

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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatternApplicationTests {

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
        Builder builder = new ComputerBuilder();
        Director director = new Director(builder);

        director.constructProduct();
    }
}
