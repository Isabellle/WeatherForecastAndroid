package com.ilepez.training.weatherforecast.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ilepez.training.weatherforecast.R;
import com.ilepez.training.weatherforecast.adapter.ConditionListAdapter;
import com.ilepez.training.weatherforecast.adapter.WeatherListAdapter;
import com.ilepez.training.weatherforecast.model.CurrentCondition;
import com.ilepez.training.weatherforecast.model.Data;
import com.ilepez.training.weatherforecast.model.Weather;
import com.ilepez.training.weatherforecast.network.NetworkManager;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailFragment extends Fragment {


    String query;
    ListView weatherListView;
    ListView currentConditionListView;
    WeatherListAdapter weatherListAdapter;
    ConditionListAdapter conditionListAdapter;
    ArrayList<Weather> weatherArrayList;
    ArrayList<CurrentCondition> currentConditionArrayList;



    public WeatherDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle.getString("city") != null)
        {
            query = bundle.getString("city");

            NetworkManager.getWeather(new NetworkManager.WeatherListener() {
                @Override
                public void onReceived(Data data) {
                    weatherArrayList = new ArrayList<Weather>();
                    weatherArrayList = data.getWeatherList();
                    weatherListAdapter = new WeatherListAdapter(weatherArrayList, getActivity());
                    weatherListView = (ListView) getView().findViewById(R.id.weatherListView);
                    weatherListView.setAdapter(weatherListAdapter);

                    currentConditionArrayList = new ArrayList<CurrentCondition>();
                    currentConditionArrayList = data.getCurrentConditionList();
                    ConditionListAdapter conditionListAdapter = new ConditionListAdapter(currentConditionArrayList, getActivity());
                    currentConditionListView = (ListView) getView().findViewById(R.id.current_weather_listview);
                    currentConditionListView.setAdapter(conditionListAdapter);


                }

                @Override
                public void onFailed() {

                }
            }, query);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_weather_detail, container, false);

        return rootView;

    }


}
