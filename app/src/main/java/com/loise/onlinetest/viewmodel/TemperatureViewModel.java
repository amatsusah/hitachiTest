package com.loise.onlinetest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.loise.onlinetest.model.Repository;
import com.loise.onlinetest.remote.objects.WeatherResponse;

public class TemperatureViewModel extends AndroidViewModel {
    private final Repository repository ;

    public TemperatureViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);

    }
    public MutableLiveData<WeatherResponse> loadData(String apiKey, String city) {
        return repository.callAPI(apiKey, city);
    }
}
