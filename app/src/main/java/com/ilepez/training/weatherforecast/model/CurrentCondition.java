package com.ilepez.training.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by student5304 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentCondition {

    private String temp_C;
    ArrayList<WeatherIconUrl> weatherIconUrl;
    ArrayList<WeatherDesc> weatherDesc;
    @JsonProperty("FeelsLikeC")
    private String FeelsLikeC;

    public CurrentCondition() {
    }

    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        FeelsLikeC = feelsLikeC;
    }

    public String getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(String temp_C) {
        this.temp_C = temp_C;
    }

    public ArrayList<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(ArrayList<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public ArrayList<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(ArrayList<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    @Override
    public String toString() {
        return "CurrentCondition{" +
                "FeelsLikeC='" + FeelsLikeC + '\'' +
                ", temp_C='" + temp_C + '\'' +
                ", weatherIconUrl=" + weatherIconUrl +
                ", weatherDesc=" + weatherDesc +
                '}';
    }
}
