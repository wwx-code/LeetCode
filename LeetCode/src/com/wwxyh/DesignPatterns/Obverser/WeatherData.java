package com.wwxyh.DesignPatterns.Obverser;

import java.util.ArrayList;

/**
 * 包含最新的天气情况信息
 * 含有观察者集合，使用ArrayList管理
 * 当数据有更新时，主动调用ArrayList，通知所有的观察者
 */
public class WeatherData implements Subject {

    private float temperature; //温度
    private float pressure; //气压
    private float humidity; //湿度
    //观察者集合
    private ArrayList<Obverser> obversers;

    public WeatherData() {
        obversers = new ArrayList<Obverser>();
    }

    //数据有更新时调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    private void dataChange() {
        //通知观察者
        notifyObserver();
    }

    //注册观察者
    @Override
    public void registerObserver(Obverser o) {
        obversers.add(o);
    }

    //移除观察者
    @Override
    public void removeObserver(Obverser o) {
        if (obversers.contains(o)) {
            obversers.remove(o);
        }
    }

    //通知观察者,遍历所有观察者，并通知
    @Override
    public void notifyObserver() {
        for (Obverser obverser : obversers) {
            obverser.update(this.temperature,this.pressure,this.humidity);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
}
