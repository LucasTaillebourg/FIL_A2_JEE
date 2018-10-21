package com.jee.capteurMQTT.dto;

public class Sensor {
    private int id;
    private City city;
    private GeoCoordinate coordinates;

    public Sensor(int id, City city) {
        this.id = id;
        this.city = city;
    }

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
 
    public GeoCoordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeoCoordinate coordinates) {
		this.coordinates = coordinates;
	}

	@Override
    public String toString() {
        return "SensorBean{" +
                "id=" + id +
                ", city=" + city +
                '}';
    }
}
