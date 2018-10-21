package com.jee.capteurMQTT.dto;


import java.time.LocalDateTime;

import com.jee.capteurMQTT.definitions.Nature;

public class Measure {
    private Sensor sensor;
    private Nature nature;
    private Float value;
    private LocalDateTime date;

    public Measure(Sensor sensor, Nature nature, Float value, LocalDateTime date) {
        this.sensor = sensor;
        this.nature = nature;
        this.value = value;
        this.date = date;
    }

    public Measure() {
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MeasureBean{" +
                "sensor=" + sensor +
                ", nature=" + nature +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
