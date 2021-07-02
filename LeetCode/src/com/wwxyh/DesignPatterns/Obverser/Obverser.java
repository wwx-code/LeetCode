package com.wwxyh.DesignPatterns.Obverser;

/**
 * @Description: 观察者接口
 * @Author: wwx
 * @Date: 2021/6/16 23:45
 */
public interface Obverser {

    //更新方法
    public void update(float temperature, float pressure, float humidity);
}
