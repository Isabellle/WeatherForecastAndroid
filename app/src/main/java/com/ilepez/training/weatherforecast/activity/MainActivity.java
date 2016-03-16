package com.ilepez.training.weatherforecast.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ilepez.training.weatherforecast.R;
import com.ilepez.training.weatherforecast.fragment.WeatherDetailFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button getWeatherButton;
    private EditText cityField;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private WeatherDetailFragment weatherDetailFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWeatherButton = (Button) findViewById(R.id.get_weather_button);
        cityField = (EditText) findViewById(R.id.city_field);

        getWeatherButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() != 0){

            switch(v.getId()){

                case R.id.get_weather_button:

                    if(cityField.getText() != null){

                        fragmentManager = getSupportFragmentManager();
                        fragmentTransaction = fragmentManager.beginTransaction();

                        bundle = new Bundle();
                        bundle.putString("city", cityField.getText().toString());

                        weatherDetailFragment = new WeatherDetailFragment();
                        weatherDetailFragment.setArguments(bundle);
                        fragmentTransaction
                                .add(R.id.main_container, weatherDetailFragment)
                                .addToBackStack(null)
                                .commit();

                    }
            }
        }

    }
}
