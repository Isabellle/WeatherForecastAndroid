package com.ilepez.training.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.ilepez.training.weatherforecast.NetworkApplication;
import com.ilepez.training.weatherforecast.R;
import com.ilepez.training.weatherforecast.model.CurrentCondition;
import com.ilepez.training.weatherforecast.model.Weather;
import com.ilepez.training.weatherforecast.model.WeatherDesc;
import com.ilepez.training.weatherforecast.model.WeatherIconUrl;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by student5304 on 16/03/16.
 */
public class ConditionListAdapter extends BaseAdapter {

    ArrayList<CurrentCondition> currentConditionArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public ConditionListAdapter(ArrayList<CurrentCondition> currentConditionArrayList, Context context) {
        super();
        this.currentConditionArrayList = currentConditionArrayList;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return currentConditionArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return currentConditionArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.current_condition, null);
        }

        CurrentCondition item = currentConditionArrayList.get(position);

        TextView currentTemperature = (TextView) convertView.findViewById(R.id.current_temperature);
        currentTemperature.setText(item.getTemp_C()+ " \u2103");

        TextView weatherCondition = (TextView) convertView.findViewById(R.id.current_weather_condition);
        WeatherDesc weatherDesc = item.getWeatherDesc().get(0);
        String desc = weatherDesc.getValue();
        weatherCondition.setText(desc);

        TextView currentTemparatureFelt = (TextView) convertView.findViewById(R.id.current_temperature_felt);
        weatherCondition.setText(item.getFeelsLikeC());

        NetworkImageView currentImage = (NetworkImageView) convertView.findViewById(R.id.current_image);
        WeatherIconUrl url = item.getWeatherIconUrl().get(0);
        String image = url.getValue();
        currentImage.setImageUrl(image, NetworkApplication.getSharedInstance().getVolleyImageLoader());

        return convertView;

    }
}
