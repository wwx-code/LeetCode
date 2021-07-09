package com.wwxyh.DesignPatterns.Factory;

/**
 * @Description: 工厂方法
 * @Author: wwx
 * @Date: 2021/7/8 23:14
 */
public class FactoryMethod {
    public static void main(String[] args) {
        ConcreteProductA concreteProductA = new ConcreteProductA();
        concreteProductA.createProduct().method1();
    }
}

//抽象产品：提供了产品的接口
interface Product {
    public void method1();
}

//具体产品1：实现抽象产品中的抽象方法
class ProductA implements Product {
    @Override
    public void method1() {
        //...
        System.out.println("ProductA");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ProductB implements Product {
    @Override
    public void method1() {
        //...
        System.out.println("ProductB");
    }
}


//抽象工厂：提供了厂品的生成方法
abstract class AbstractFactory {
    //稳定的，处理成抽象方法

    //工厂方法，使一个类的实例化延迟到其子类
    abstract Product createProduct();

    Product getObject(){
        Product product = createProduct();
        //...
        return product;
    }
}

//具体工厂A：实现了厂品的生成方法
class ConcreteProductA extends AbstractFactory {
    //具体实现
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

//具体工厂B：实现了厂品的生成方法
class ConcreteProductB extends AbstractFactory {
    //具体实现
    @Override
    Product createProduct() {
        return new ProductB();
    }
}
