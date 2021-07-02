package com.wwxyh.DesignPatterns.Obverser;

/**
 * @Description: 当前天气
 * @Author: wwx
 * @Date: 2021/6/16 23:49
 */
public class CurrentConditions implements Obverser {

    private float temperature; //温度
    private float pressure; //气压
    private float humidity; //湿度

    //更新天气，由 WeatherData 来调用
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //显示
    private void display() {
        System.out.println("今天的温度为：" + temperature);
        System.out.println("今天的气压为：" + pressure);
        System.out.println("今天的湿度为：" + humidity);
    }
}
