package com.example.demo;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Service
public class WeatherService {
    @Autowired
    private WeatherRestMap weatherRestMap;

    public boolean isCity(String city) throws IOException {
        return weatherRestMap.isCity(city);
    }

    public WeatherNow getCurrentWeather(String city){
        return weatherRestMap.getNowWeather(city);
    }
}