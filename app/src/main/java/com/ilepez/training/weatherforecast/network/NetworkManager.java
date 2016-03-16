package com.ilepez.training.weatherforecast.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.ilepez.training.weatherforecast.NetworkApplication;
import com.ilepez.training.weatherforecast.model.ContentData;
import com.ilepez.training.weatherforecast.model.Data;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;
import java.lang.Override;
import java.lang.String;

/**
 * Created by student5304 on 08/03/16.
 */
public class NetworkManager {

    private static String url;

    public interface WeatherListener
    {
        void onReceived(Data data);
        void onFailed();

    }

    private static final String urlMessages = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=900077b4736346f2a05230219161503&q=";

    //pour éviter de se trimgballer des variables d'instances
    public static void getWeather(final WeatherListener listener, String search){

        if(search!=null){
            url = urlMessages + search + "&num_of_days=5&tp=3&format=json";
        }

        JacksonRequest<ContentData> jacksonRequest = new JacksonRequest<ContentData>(Request.Method.GET, url, new JacksonRequestListener<ContentData>() {
            @Override
            public void onResponse(ContentData response, int statusCode, VolleyError error) {

                if(error != null){
                    if(listener != null){
                        Log.d("fail", String.valueOf(error));
                        listener.onFailed();
                    }
                }
                else if (response != null){
                    if(listener != null){
                        listener.onReceived(response.getData());
                    }
                }

            }

            @Override
            public JavaType getReturnType() {
                //return ArrayType.construct(SimpleType.construct(RequestWeather.class), null, null);
                return SimpleType.construct(ContentData.class);
            }

        });

        NetworkApplication.getSharedInstance().getVolleyRequestQueue().add(jacksonRequest);

    }
}
