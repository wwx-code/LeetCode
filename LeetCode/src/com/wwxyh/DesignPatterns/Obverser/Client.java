package com.wwxyh.DesignPatterns.Obverser;

/**
 * @Description: 客户端
 * @Author: wwx
 * @Date: 2021/6/17 0:11
 */
public class Client {
    public static void main(String[] args) {
        //创建一个WeatherData
        WeatherData weatherData = new WeatherData();
        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        //注册到WeatherData
        weatherData.registerObserver(currentConditions);
        //WeatherData更新数据
        weatherData.setData(33f,100f,25f);
    }
}
