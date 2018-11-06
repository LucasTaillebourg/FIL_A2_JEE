package com.jee.bean;

import com.jee.models.Country;

public class CounrtyBean {
    private String id;
    private String name;

    public CounrtyBean(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public CounrtyBean(Country country) {
    	this.id = country.getId();
    	this.name = country.getName();
    }

    public CounrtyBean() {
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

    @Override
    public String toString() {
        return "CounrtyBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
