package com.loise.onlinetest.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.loise.onlinetest.remote.api.Helper;
import com.loise.onlinetest.remote.objects.WeatherResponse;
import rx.Observer;
import rx.schedulers.Schedulers;

public class Repository {
    private final MutableLiveData<WeatherResponse>weatherLiveData;

    public Repository(Application application) {
        weatherLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<WeatherResponse> callAPI(String apiKey, String city){
        new Helper().networkCall.getWeather(apiKey,city)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(new Observer<WeatherResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        weatherLiveData.postValue(null);
                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        weatherLiveData.postValue(weatherResponse);
                    }
                });
        return weatherLiveData;
    }
}

