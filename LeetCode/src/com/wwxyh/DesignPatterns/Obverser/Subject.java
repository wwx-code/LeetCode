package com.wwxyh.DesignPatterns.Obverser;

/**
 * @Description: 主题接口(发布者、被观察者)
 * @Author: wwx
 * @Date: 2021/6/16 23:42
 */
public interface Subject {
    //注册观察者
    public void registerObserver(Obverser o);
    //移除观察者
    public void removeObserver(Obverser o);
    //通知观察者
    public void notifyObserver();
}
