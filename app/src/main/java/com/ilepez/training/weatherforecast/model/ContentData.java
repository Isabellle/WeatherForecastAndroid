package com.ilepez.training.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by student5304 on 16/03/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class ContentData {


    private Data data;

    public ContentData(){
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ContentData{" +
                "data=" + data +
                '}';
    }
}
