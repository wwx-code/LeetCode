package com.wwxyh.DesignPatterns.Proxy;

/**
 * @Description: 静态代理
 * @Author: wwx
 * @Date: 2021/7/10 22:31
 */
public class StaticProxy {
    public static void main(String[] args) {
        //创建目标对象（被代理对象）
        Teacher teacher = new Teacher();

        //创建代理对象，同时将被代理对象传递给代理对象
        TeacherProxy teacherProxy = new TeacherProxy(teacher);

        //通过代理对象对象调用被代理对象的方法
        teacherProxy.teach();
    }
}

interface ITeacherDao{
    void teach();
}

//目标对象
class Teacher implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("正在教书...");
    }
}

//代理对象
class TeacherProxy implements ITeacherDao{

    //目标对象，通过接口聚合
    private ITeacherDao target;

    public TeacherProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("正在代理...");  //前置方法
        target.teach();
        System.out.println("代理完成...");  //后置方法
    }
}
