package com.jee.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Measure", schema = "public", catalog = "databaseJEE")
public class MeasureEntity {
	@Id
	@SequenceGenerator(name="MEASURE_ID_GENERATOR", sequenceName="MEASURE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURE_ID_GENERATOR")
	private int id;
	
    private String nature;
    private Timestamp date;
    private Double value;
    private Long sensorId;
    private SensorEntity sensorBySensorId;

    
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nature")
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "sensor_id")
    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasureEntity that = (MeasureEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nature, that.nature) &&
                Objects.equals(date, that.date) &&
                Objects.equals(value, that.value) &&
                Objects.equals(sensorId, that.sensorId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nature, date, value, sensorId);
    }

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    public SensorEntity getSensorBySensorId() {
        return sensorBySensorId;
    }

    public void setSensorBySensorId(SensorEntity sensorBySensorId) {
        this.sensorBySensorId = sensorBySensorId;
    }
}
