package com.jee.capteurMQTT.dto;

public class City {
    private String id;
    private String name;
    private Counrty country;

    public City(String id, String name, Counrty country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public City() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counrty getCountry() {
        return country;
    }

    public void setCountry(Counrty country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
