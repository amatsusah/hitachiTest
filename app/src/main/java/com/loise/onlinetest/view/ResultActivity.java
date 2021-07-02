package com.loise.onlinetest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.EditText;

import com.loise.onlinetest.R;
import com.loise.onlinetest.remote.objects.WeatherResponse;
import com.loise.onlinetest.viewmodel.TemperatureViewModel;

public class ResultActivity extends AppCompatActivity {
WeatherResponse weatherData;
EditText celcius, fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        celcius = findViewById(R.id.etCelsius);
        fahrenheit = findViewById(R.id.etfahrenheit);
        new TemperatureViewModel(getApplication()).loadData(getIntent().getStringExtra("apikey"), getIntent().getStringExtra("city")).observe(this, response -> {
            if(response!=null){
                weatherData = response;
                celcius.setText(String.valueOf(response.current.getTemp_c()));
                fahrenheit.setText(String.valueOf(response.current.getTemp_f()));
            }else{
                celcius.setText("No Internet");
                fahrenheit.setText("or Incorrect API Key");
            }
        });
    }


}