package com.wwxyh.DesignPatterns.singleton;

/**
 * @Description: 懒汉式
 * @Author: wwx
 * @Date: 2021/5/31 14:46
 */
public class LHan {

    private LHan(){

    }

    //volatile:重排序被禁止
    private volatile static LHan lHan;

    //双重检测锁模式 懒汉式单例 DCL懒汉式
    public static LHan getInstance(){
        if (lHan == null){
            synchronized (LHan.class){
                if (lHan == null){
                    lHan = new LHan(); //不是一个原子性操作
                    /**
                     * volatile保证顺序
                     * 1、分配内存空间
                     * 2、执行构造方法，初始化对象
                     * 3、把这个对象指向这个空间
                     **/
                }
            }
        }
        return lHan;
    }
}
