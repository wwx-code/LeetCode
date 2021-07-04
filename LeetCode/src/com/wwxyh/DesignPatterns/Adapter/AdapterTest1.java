package com.wwxyh.DesignPatterns.Adapter;

/**
 * @Description:
 * @Author: wwx
 * @Date: 2021/7/3 16:56
 */
public class AdapterTest1 {
    public static void main(String[] args) {
//        Adaptee adaptee = new Adaptee();
//        Target target = new Adapter(adaptee);
//        target.output5v();

        Adapter2 adapter2 = new Adapter2();
        adapter2.output5v();
        //类适配器缺点之一：对接口有污染，能调用220v的方法
        adapter2.output220v();
    }
}

// 被适配的类
// 标准电压：220v
class Adaptee{
    public int output220v(){
        return 220;
    }
}

//目标接口，输出5v
interface Target{
    int output5v();
}

//对象适配器模式
class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        System.out.println(String.format("原电压为： %d v  -> 输出电压为： %d v",i,5));
        return i;
    }
}

//类适配器模式
class Adapter2 extends Adaptee implements Target{

    @Override
    public int output5v() {
        //直接调用父类的方法
        int i = output220v();
        System.out.println(String.format("原电压为： %d v  -> 输出电压为： %d v",i,5));
        return i;
    }
}