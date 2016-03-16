package com.ilepez.training.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Created by student5304 on 16/03/16.
 */
public class Data {

    @JsonProperty("current_condition")
    private ArrayList<CurrentCondition> currentConditionList;

    @JsonProperty("weather")
    private ArrayList<Weather> weatherList;

    public Data() {
    }
    public ArrayList<CurrentCondition> getCurrentConditionList() {
        return currentConditionList;
    }

    public void setCurrentConditionList(ArrayList<CurrentCondition> currentConditionList) {
        this.currentConditionList = currentConditionList;
    }

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "currentConditionList=" + currentConditionList +
                ", weatherList=" + weatherList +
                '}';
    }
}
