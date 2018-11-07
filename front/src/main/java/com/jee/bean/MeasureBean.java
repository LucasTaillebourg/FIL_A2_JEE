package com.jee.bean;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.jee.models.Measure;

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
    
    public MeasureBean(Measure measure) {
    	this.sensor = new SensorBean(measure.getSensor());
    	this.nature = Nature.valueOf(measure.getNature());
    	this.value = Float.valueOf(Double.toString(measure.getValue()));
    	this.date = measure.getDate().toLocalDateTime();
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
    public String getDateToString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        return date.format(formatter);
    }
    public String getDateDiff() {

    	long minutes = ChronoUnit.MINUTES.between(date, LocalDateTime.now());
 return minutes +" min";
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
