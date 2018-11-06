package com.jee.bean;

import com.jee.models.Sensor;

public class SensorBean {
    private int id;
    private CityBean city;
    private float lon;
    private float lat;

    public SensorBean(int id, CityBean city) {
        this.id = id;
        this.city = city;
    }
    
    public SensorBean(Sensor sensor) {
    	this.id = sensor.getId().intValue();
    	this.city = new CityBean(sensor.getCity());
    	this.lon = sensor.getLongitude().floatValue();
    	this.lat = sensor.getLatitude().floatValue();
    	   	
    }

    public SensorBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "SensorBean{" +
                "id=" + id +
                ", city=" + city +
                '}';
    }
}
