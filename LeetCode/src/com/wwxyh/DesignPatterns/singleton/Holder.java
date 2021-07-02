package com.wwxyh.DesignPatterns.singleton;

/**
 * @Description: 静态内部类
 * @Author: wwx
 * @Date: 2021/5/31 15:08
 */
public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
