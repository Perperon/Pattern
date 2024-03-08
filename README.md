### java设计模式

1. **创建型模式（Creational Patterns）：**
   - **单例模式（Singleton Pattern）：** 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
   - **工厂模式（Factory Pattern）：** 定义一个创建对象的接口，但由子类决定要实例化的类是哪一个。
   - **抽象工厂模式（Abstract Factory Pattern）：** 提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
   - **建造者模式（Builder Pattern）：** 将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
   - **原型模式（Prototype Pattern）：** 用于创建对象的一种模式，通过复制现有的对象来创建新对象。
2. **结构型模式（Structural Patterns）：**
   - **适配器模式（Adapter Pattern）：** 将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的类可以一起工作。
   - **桥接模式（Bridge Pattern）：** 将抽象部分与它的实现部分分离，以便它们可以独立地变化。
   - **组合模式（Composite Pattern）：** 将对象组合成树形结构以表示“部分-整体”的层次结构，使得客户端对单个对象和组合对象的使用具有一致性。
   - **装饰器模式（Decorator Pattern）：** 动态地给一个对象添加一些额外的职责，同时又不改变其结构。
   - **外观模式（Facade Pattern）：** 为子系统中的一组接口提供一个统一的接口，以简化子系统的使用。
   - **享元模式（Flyweight Pattern）：** 通过共享技术实现相同或相似对象的重用，以减少内存使用和提高性能。
   - **代理模式（Proxy Pattern）：** 为其他对象提供一种代理以控制对这个对象的访问。
3. **行为型模式（Behavioral Patterns）：**
   - **责任链模式（Chain of Responsibility Pattern）：** 为解除请求的发送者和接收者之间的耦合，而是请求沿链传递，直到有一个对象处理它为止。
   - **命令模式（Command Pattern）：** 将一个请求封装成一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作。
   - **解释器模式（Interpreter Pattern）：** 给定一个语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。
   - **迭代器模式（Iterator Pattern）：** 提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露其内部的表示。
   - **中介者模式（Mediator Pattern）：** 用一个中介对象来封装一系列的对象交互，使得各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
   - **备忘录模式（Memento Pattern）：** 在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以后可以将该对象恢复到原先保存的状态。
   - **观察者模式（Observer Pattern）：** 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象，当主题对象发生变化时，它的所有依赖者都会收到通知并自动更新。
   - **状态模式（State Pattern）：** 允许对象在其内部状态改变时改变它的行为，对象看起来好像修改了它的类。
   - **策略模式（Strategy Pattern）：** 定义了一系列的算法，并将每一个算法封装起来，使得它们可以相互替换，使得算法的变化不会影响到使用算法的客户。
   - **模板方法模式（Template Method Pattern）：** 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
   - **访问者模式（Visitor Pattern）：** 表示一个作用于某对象结构中的各元素的操作，它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
