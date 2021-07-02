package com.loise.onlinetest.remote.objects;

public class WeatherResponse {
    public Location location;
    public Current current;

    public WeatherResponse() {
    }

    public WeatherResponse(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
