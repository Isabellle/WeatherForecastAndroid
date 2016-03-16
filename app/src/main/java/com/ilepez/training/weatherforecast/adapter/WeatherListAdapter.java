package com.ilepez.training.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ilepez.training.weatherforecast.R;
import com.ilepez.training.weatherforecast.model.Weather;

import java.util.ArrayList;

/**
 * Created by student5304 on 16/03/16.
 */
public class WeatherListAdapter extends BaseAdapter {

    ArrayList<Weather> weatherArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public WeatherListAdapter(ArrayList<Weather> weatherArrayList, Context context) {
        super();
        this.weatherArrayList = weatherArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return weatherArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.weather_row, null);
        }

        Weather item = weatherArrayList.get(position);

        TextView weatherTemperature = (TextView) convertView.findViewById(R.id.weather_temperature);
        weatherTemperature.setText(item.getDate());

        return convertView;

    }
}
