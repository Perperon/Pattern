package com.perperon.pattern;

import com.perperon.pattern.adapter.Adaptee;
import com.perperon.pattern.adapter.Target;
import com.perperon.pattern.adapter.impl.AdapteeClass;
import com.perperon.pattern.adapter.impl.Adapter;
import com.perperon.pattern.bridge.Circle;
import com.perperon.pattern.bridge.Shape;
import com.perperon.pattern.bridge.circle.BlueCircle;
import com.perperon.pattern.bridge.circle.RedCircle;
import com.perperon.pattern.builder.Director;
import com.perperon.pattern.builder.build.Builder;
import com.perperon.pattern.builder.build.service.ComputerBuilder;
import com.perperon.pattern.chain.ChainHandler;
import com.perperon.pattern.chain.Request;
import com.perperon.pattern.chain.impl.ConcreteHandlerA;
import com.perperon.pattern.chain.impl.ConcreteHandlerB;
import com.perperon.pattern.command.Command;
import com.perperon.pattern.command.Invoker;
import com.perperon.pattern.command.Receiver;
import com.perperon.pattern.command.impl.ConcreteCommand;
import com.perperon.pattern.composite.impl.Composite;
import com.perperon.pattern.composite.impl.Leaf;
import com.perperon.pattern.decorator.Coffee;
import com.perperon.pattern.decorator.dec.Milk;
import com.perperon.pattern.decorator.dec.Sugar;
import com.perperon.pattern.decorator.impl.SimpleCoffee;
import com.perperon.pattern.factory.abs.Battery;
import com.perperon.pattern.factory.abs.Car;
import com.perperon.pattern.factory.abs.fac.CarFactory;
import com.perperon.pattern.factory.abs.fac.impl.ElectricCarFactory;
import com.perperon.pattern.factory.abs.fac.impl.GasolineCarFactory;
import com.perperon.pattern.factory.eazy.Product;
import com.perperon.pattern.factory.eazy.fac.ProductFactory;
import com.perperon.pattern.fly.Flyweight;
import com.perperon.pattern.fly.factory.FlyweightFactory;
import com.perperon.pattern.interpreter.Context;
import com.perperon.pattern.interpreter.Expression;
import com.perperon.pattern.iterator.OIterator;
import com.perperon.pattern.iterator.impl.ConcreteAggregate;
import com.perperon.pattern.mediator.Colleague;
import com.perperon.pattern.mediator.Mediator;
import com.perperon.pattern.mediator.impl.ConcreteColleague;
import com.perperon.pattern.mediator.impl.ConcreteMediator;
import com.perperon.pattern.memento.Caretaker;
import com.perperon.pattern.memento.Originator;
import com.perperon.pattern.observer.Observer;
import com.perperon.pattern.observer.concrete.ConcreteObserver;
import com.perperon.pattern.observer.concrete.ConcreteSubject;
import com.perperon.pattern.prototype.deep.Animal;
import com.perperon.pattern.prototype.deep.Dog;
import com.perperon.pattern.prototype.shallow.Address;
import com.perperon.pattern.prototype.shallow.Person;
import com.perperon.pattern.proxy.cglib.dynamic.AliSmsService;
import com.perperon.pattern.proxy.cglib.dynamic.factory.CglibProxyFactory;
import com.perperon.pattern.proxy.jdk.dynamic.SmsService;
import com.perperon.pattern.proxy.jdk.dynamic.factory.JdkProxyFactory;
import com.perperon.pattern.proxy.jdk.dynamic.impl.SmsServiceImpl;
import com.perperon.pattern.proxy.state.proxy.SmsProxy;
import com.perperon.reflect.TargetObject;
import com.perperon.pattern.state.ContextState;
import com.perperon.pattern.state.impl.StateA;
import com.perperon.pattern.strategy.ContextStrategy;
import com.perperon.pattern.strategy.impl.OperationAdd;
import com.perperon.pattern.strategy.impl.OperationMultiply;
import com.perperon.pattern.strategy.impl.OperationSubtract;
import com.perperon.pattern.template.ConcreteClassA;
import com.perperon.pattern.template.ConcreteClassB;
import com.perperon.pattern.template.TemplateClass;
import com.perperon.pattern.visitor.Element;
import com.perperon.pattern.visitor.Visitor;
import com.perperon.pattern.visitor.impl.ConcreteElementA;
import com.perperon.pattern.visitor.impl.ConcreteElementB;
import com.perperon.pattern.visitor.impl.ConcreteVisitor;
import com.perperon.thread.ThreadLocalExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

@SpringBootTest
class PatternApplicationTests {

    // 创建ThreadLocal实例
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    /**
     * 静态代理
     */
    @Test
    public void test1() {
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
    public void test4() {
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
    public void test9() {
        //浅拷贝
        Person person = new Person(new Address("张三"));
        Person personCopy = person.clone();
        System.out.println(person.getAddress());
        System.out.println(personCopy.getAddress());
        System.out.println(person.getAddress() == personCopy.getAddress());

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
     * <p>
     * 简单的ThreadLocal使用示例，演示了如何在多线程环境中为每个线程保存独立的变量值
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
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    /**
     * 适配器模式测试
     */
    @Test
    public void test10() {
        // 创建适配者对象
        Adaptee adaptee = new AdapteeClass();
        // 创建适配器对象，传入适配者对象
        Target target = new Adapter(adaptee);
        // 客户端通过目标接口调用方法
        target.request();
    }

    /**
     * 桥接模式测试
     */
    @Test
    public void test11() {
        // 创建一个红色的圆形对象
        Shape redCircle = new Circle(new RedCircle());
        // 调用红色圆形的绘制方法
        redCircle.draw();

        // 创建一个蓝色的圆形对象
        Shape blueCircle = new Circle(new BlueCircle());
        // 调用蓝色圆形的绘制方法
        blueCircle.draw();
    }

    /**
     * 组合模式测试
     */
    @Test
    public void test12() {
        // 创建组合节点
        Composite root = new Composite("Root");
        // 创建叶子节点
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        // 将叶子节点添加到组合节点中
        root.add(leaf1);
        root.add(leaf2);
        // 创建另一个组合节点
        Composite composite1 = new Composite("Composite 1");
        Leaf leaf3 = new Leaf("Leaf 3");
        Leaf leaf4 = new Leaf("Leaf 4");
        // 将叶子节点添加到组合节点中
        composite1.add(leaf3);
        composite1.add(leaf4);
        // 将组合节点添加到根组合节点中
        root.add(composite1);
        // 执行操作
        root.operation();
    }

    /**
     * 装饰器模式测试
     */
    @Test
    public void test13() {
        // 创建一个简单的咖啡对象
        Coffee coffee = new SimpleCoffee();
        // 输出简单咖啡的成分和价格
        System.out.println("Simple Coffee: " + coffee.getIngredients() + ", Cost: $" + coffee.getCost());

        // 将咖啡对象装饰为加牛奶的咖啡
        coffee = new Milk(coffee);
        // 输出加牛奶的咖啡的成分和价格
        System.out.println("Coffee with Milk: " + coffee.getIngredients() + ", Cost: $" + coffee.getCost());

        // 将咖啡对象装饰为加牛奶和糖的咖啡
        coffee = new Sugar(coffee);
        // 输出加牛奶和糖的咖啡的成分和价格
        System.out.println("Coffee with Milk and Sugar: " + coffee.getIngredients() + ", Cost: $" + coffee.getCost());
    }

    /**
     * 享元模式测试
     */
    @Test
    public void test14() {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("state1");
        Flyweight flyweight2 = factory.getFlyweight("state2");
        Flyweight flyweight3 = factory.getFlyweight("state1"); // 这个将是之前创建的flyweight1的复用

        flyweight1.operation("extrinsicState1");
        flyweight2.operation("extrinsicState2");
        flyweight3.operation("extrinsicState3"); // 这个将复用flyweight1的内部状态
    }

    /**
     * 责任链模式测试
     */
    @Test
    public void test15() {
        // 创建ChainHandler类型的handlerA对象，并将其初始化为ConcreteHandlerA类的实例
        ChainHandler handlerA = new ConcreteHandlerA(null);
        // 创建ChainHandler类型的handlerB对象，并将其初始化为ConcreteHandlerB类的实例，同时将handlerA作为后继处理器
        ChainHandler handlerB = new ConcreteHandlerB(handlerA);

        // 创建Request类型的request1对象，并将其请求数据设置为"A"
        Request request1 = new Request("A");
        // 调用handlerB对象的handleRequest方法处理request1请求，并打印返回的响应数据
        // 输出结果：Handled by ConcreteHandlerA
        System.out.println(handlerB.handleRequest(request1).getResponseData());

        // 创建Request类型的request2对象，并将其请求数据设置为"B"
        Request request2 = new Request("B");
        // 调用handlerB对象的handleRequest方法处理request2请求，并打印返回的响应数据
        // 输出结果：Handled by ConcreteHandlerB
        System.out.println(handlerB.handleRequest(request2).getResponseData());

        // 创建Request类型的request3对象，并将其请求数据设置为"C"
        Request request3 = new Request("C");
        // 调用handlerB对象的handleRequest方法处理request3请求，并打印返回的响应数据
        // 输出结果：Unhandled request
        System.out.println(handlerB.handleRequest(request3).getResponseData());
    }

    /**
     * 命令模式测试
     */
    @Test
    public void test16() {
        // 创建接收者对象
        Receiver receiver = new Receiver();

        // 创建具体命令对象，并将接收者对象传入
        Command command = new ConcreteCommand(receiver);

        // 创建调用者对象，并将命令对象传入
        Invoker invoker = new Invoker(command);

        // 执行命令
        invoker.executeCommand();

        // 撤销命令（如果支持的话）
        // invoker.undoCommand();
    }

    /**
     * 解释器模式测试
     */
    @Test
    public void test17() {
        // 创建解释器上下文
        Context context = new Context();

        // 解析表达式 "5 + 3"，并返回对应的表达式对象
        Expression expression1 = context.parse("5 + 3");
        // 输出表达式 "5 + 3" 的计算结果
        System.out.println("Result of 5 + 3: " + expression1.interpret());

        // 解析表达式 "10 - 4"，并返回对应的表达式对象
        Expression expression2 = context.parse("10 - 4");
        // 输出表达式 "10 - 4" 的计算结果
        System.out.println("Result of 10 - 4: " + expression2.interpret());

        // 解析表达式 "15"，并返回对应的表达式对象
        Expression expression3 = context.parse("15");
        // 输出表达式 "15" 的值
        System.out.println("Value of 15: " + expression3.interpret());
    }

    /**
     * 迭代器模式测试
     */
    @Test
    public void test18() {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add("Element 1");
        aggregate.add("Element 2");
        aggregate.add("Element 3");

        OIterator iterator = aggregate.creatIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 中介者模式测试
     */
    @Test
    public void test19() {
        Mediator mediator = new ConcreteMediator();

        Colleague colleagueA = new ConcreteColleague("Colleague A", mediator);
        Colleague colleagueB = new ConcreteColleague("Colleague B", mediator);
        Colleague colleagueC = new ConcreteColleague("Colleague C", mediator);

        colleagueA.send("Hello from A");
        colleagueB.send("Hello from B");
        colleagueC.send("Hello from C");
    }

    /**
     * 备忘录模式测试
     */
    @Test
    public void test20() {
        // 创建Originator对象
        Originator originator = new Originator();
        originator.setState("State A");
        System.out.println("Originator state: " + originator.getState());

        // 创建Caretaker对象并保存备忘录
        Caretaker caretaker = new Caretaker();
        caretaker.addMemento(originator.createMemento());

        // 修改Originator的状态
        originator.setState("State B");
        System.out.println("Originator state after modification: " + originator.getState());

        // 从Caretaker恢复备忘录
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("Originator state after restoration: " + originator.getState());
    }

    /**
     * 状态模式测试
     */
    @Test
    public void test21() {
        ContextState context = new ContextState(new StateA());
        context.request(); // 处理A状态的业务逻辑，并转换到B状态
        context.request(); // 处理B状态的业务逻辑，并转换回A状态
        context.request(); // 再次处理A状态的业务逻辑...
    }

    /**
     * 策略模式测试
     */
    @Test
    public void test22() {
        ContextStrategy context = new ContextStrategy(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new ContextStrategy(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new ContextStrategy(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

    /**
     * 模板方法模式测试
     */
    @Test
    public void test23() {
        TemplateClass a = new ConcreteClassA();
        TemplateClass b = new ConcreteClassB();

        a.templateMethod(); // 输出具体实现A的算法步骤
        b.templateMethod(); // 输出具体实现B的算法步骤
    }

    /**
     * 访问者模式测试
     */
    @Test
        public void test24() {
            // 创建被访问对象elementA
            Element elementA = new ConcreteElementA();
            // 创建被访问对象elementB
            Element elementB = new ConcreteElementB();

            // 创建访问者对象visitor
            Visitor visitor = new ConcreteVisitor();

            // 使用elementA接受访问者visitor
            elementA.accept(visitor);
            // 使用elementB接受访问者visitor
            elementB.accept(visitor);
        }


    /**
     * 测试反射
     */
    @Test
    public void test25() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.perperon.reflect.TargetObject");
        TargetObject o = (TargetObject)clazz.newInstance();
        /**
         * 获取 TargetObject 类中定义的所有方法
         */
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /**
         * 获取指定方法并调用
         */
        Method publicMethod = clazz.getDeclaredMethod("publicMethod",
                String.class);

        publicMethod.invoke(o, "JavaGuide");
        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = clazz.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(o, "Hello World");

        /**
         * 调用 private 方法
         */
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(o);
    }
}
