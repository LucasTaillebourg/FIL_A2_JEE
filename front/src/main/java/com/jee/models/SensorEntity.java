package com.jee.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Sensor", schema = "public", catalog = "databaseJEE")
public class SensorEntity {
    private long id;
    private String cityId;
    private BigInteger latitude;
    private BigInteger longitude;
    private Collection<MeasureEntity> measuresById;
    private CityEntity cityByCityId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city_id")
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "latitude")
    public BigInteger getLatitude() {
        return latitude;
    }

    public void setLatitude(BigInteger latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigInteger getLongitude() {
        return longitude;
    }

    public void setLongitude(BigInteger longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorEntity that = (SensorEntity) o;
        return id == that.id &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cityId, latitude, longitude);
    }

    @OneToMany(mappedBy = "sensorBySensorId")
    public Collection<MeasureEntity> getMeasuresById() {
        return measuresById;
    }

    public void setMeasuresById(Collection<MeasureEntity> measuresById) {
        this.measuresById = measuresById;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
