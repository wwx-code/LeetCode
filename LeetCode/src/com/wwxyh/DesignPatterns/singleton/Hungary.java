package com.wwxyh.DesignPatterns.singleton;

/**
 * @Description: 饿汉式
 * @Author: wwx
 * @Date: 2021/5/31 14:47
 */
public class Hungary {

    //可能会浪费空间
    private byte[] byte1 = new byte[1024 * 1024];
    private byte[] byte2 = new byte[1024 * 1024];
    private byte[] byte3 = new byte[1024 * 1024];
    private byte[] byte4 = new byte[1024 * 1024];

    private Hungary(){

    }

    private final static Hungary HUNGARY = new Hungary();

    public static Hungary getInstance(){
        return HUNGARY;
    }
}
