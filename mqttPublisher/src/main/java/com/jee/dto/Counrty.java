package com.jee.capteurMQTT.dto;

public class Counrty {
    private String id;
    private String name;

    public Counrty(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Counrty() {
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
