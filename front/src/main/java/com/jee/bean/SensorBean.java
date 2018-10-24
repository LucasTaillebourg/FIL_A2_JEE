package com.jee.bean;

public class SensorBean {
    private int id;
    private CityBean city;

    public SensorBean(int id, CityBean city) {
        this.id = id;
        this.city = city;
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

    @Override
    public String toString() {
        return "SensorBean{" +
                "id=" + id +
                ", city=" + city +
                '}';
    }
}
