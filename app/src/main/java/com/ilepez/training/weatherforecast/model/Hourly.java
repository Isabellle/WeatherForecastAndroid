package com.ilepez.training.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by Training on 16/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hourly {

    String time;
    String tempC;
    ArrayList<WeatherIconUrl> weatherIconUrl;
    ArrayList<WeatherDesc> weatherDesc;
    String chanceofrain;

    public Hourly() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public ArrayList<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(ArrayList<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public ArrayList<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(ArrayList<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getChanceofrain() {
        return chanceofrain;
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "time='" + time + '\'' +
                ", tempC='" + tempC + '\'' +
                ", weatherIconUrl=" + weatherIconUrl +
                ", weatherDesc=" + weatherDesc +
                ", chanceofrain='" + chanceofrain + '\'' +
                '}';
    }
}
