package com.wwxyh.DesignPatterns.Decorator;

/**
 * @Description: 装饰器模式
 * @Author: wwx
 * @Date: 2021/7/29 23:11
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator2(new ConcreteDecorator(new ConcreteComponent()));
        component.operation();
    }
}

//抽象构件角色
interface Component{
    void operation();
}
//具体构件角色
class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}

//抽象装饰角色
abstract class Decorator implements Component{
    Component component;

    //包含具体构件的实例
    public Decorator(Component component) {
        this.component = component;
    }
}

//具体装饰角色
class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("滤镜");
        component.operation();
    }
}

class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        component.operation();
    }
}
