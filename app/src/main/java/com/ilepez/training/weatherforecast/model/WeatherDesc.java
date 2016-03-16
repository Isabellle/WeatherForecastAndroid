package com.ilepez.training.weatherforecast.model;

/**
 * Created by student5304 on 16/03/16.
 */
public class WeatherDesc {

    String value;

    public WeatherDesc() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WeatherDesc{" +
                "value='" + value + '\'' +
                '}';
    }
}
