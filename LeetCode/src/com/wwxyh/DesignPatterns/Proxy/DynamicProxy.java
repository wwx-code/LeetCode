package com.wwxyh.DesignPatterns.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: JDK动态代理
 * @Author: wwx
 * @Date: 2021/7/10 23:32
 */
public class DynamicProxy {
    public static void main(String[] args) {
        //创建目标对象
        ITeachDao target = new Teachers();

        //给目标对象创建代理对象
        ITeachDao proxyInstance = (ITeachDao) new ProxyFactory(target).getProxyInstance();

        //proxy:class com.wwxyh.DesignPatterns.Proxy.$Proxy0  表示内存中动态生成了代理对象
        System.out.println("proxyInstance:" + proxyInstance.getClass());

        //通过代理对象调用目标对象的方法
        proxyInstance.sayHello("world");
    }
}

interface ITeachDao{
    void teach();
    void sayHello(String name);
}

class Teachers implements ITeachDao{
    @Override
    public void teach() {
        System.out.println("老师正在授课");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}

class ProxyFactory{
    //维护目标对象，Object
    private Object target;

    //构造器，对target进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance(){

        /*
         * public static Object newProxyInstance(ClassLoader loader,
         *                                       Class<?>[] interfaces,
         *                                       InvocationHandler h)
         * 1、ClassLoader loader：指定当前目标对象使用的类加载器，获取加载器的方法是固定的
         * 2、Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认类型
         * 3、InvocationHandler h：事情处理，执行目标对象的方法时，会触发事情处理器方法。会把当前执行的目标对象方法作为参数传入
         **/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    //1、Object proxy：代理对象
                    //2、Method method：代理的方法
                    //3、Object[] args：参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始...");
                        //proxy:class com.wwxyh.DesignPatterns.Proxy.$Proxy0
                        System.out.println("proxy:" + proxy.getClass());
                        //method:sayHello
                        System.out.println("method:" + method.getName());

                        //通过反射机制调用目标对象的方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("授课结束...");
                        return returnValue;
                    }
                });
    }
}
