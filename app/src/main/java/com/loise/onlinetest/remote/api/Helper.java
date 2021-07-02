package com.loise.onlinetest.remote.api;

import com.loise.onlinetest.remote.objects.WeatherResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public class Helper {
    public NetworkCall networkCall;

    public interface NetworkCall {
        @GET("/v1/current.json")
        Observable<WeatherResponse> getWeather(@Query("key") String apiKey, @Query("q") String city);
    }

    public Helper() {

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl("http://api.weatherapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                ;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();
        networkCall = retrofit.create(NetworkCall.class);
    }

    Observable<WeatherResponse> getCurrentWeather(String apiKey, String city) {
        return networkCall.getWeather(apiKey,city);
    }
}
