package com.jee.bean;

import com.jee.models.City;

public class CityBean {
    private String id;
    private String name;
    private CounrtyBean country;

    public CityBean(String id, String name, CounrtyBean country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    
    public CityBean(City city) {
    	this.id = city.getId();
    	this.name = city.getName();
    	this.country = new CounrtyBean(city.getCountry());
    }

    public CityBean() {
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

    public CounrtyBean getCountry() {
        return country;
    }

    public void setCountry(CounrtyBean country) {
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
