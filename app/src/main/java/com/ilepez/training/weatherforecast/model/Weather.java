package com.ilepez.training.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by student5304 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private String date;
    private String maxtempC;
    private String mintempC;
    private ArrayList<Hourly> hourly;

    public Weather() {
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", maxtempC='" + maxtempC + '\'' +
                ", mintempC='" + mintempC + '\'' +
                ", hourly=" + hourly +
                '}';
    }
}
