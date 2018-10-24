package com.jee.bean;

import java.time.LocalDateTime;

public class MeasureBean {
    private SensorBean sensor;
    private Nature nature;
    private Float value;
    private LocalDateTime date;

    public MeasureBean(SensorBean sensor, Nature nature, Float value, LocalDateTime date) {
        this.sensor = sensor;
        this.nature = nature;
        this.value = value;
        this.date = date;
    }

    public MeasureBean() {
    }

    public SensorBean getSensor() {
        return sensor;
    }

    public void setSensor(SensorBean sensor) {
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
