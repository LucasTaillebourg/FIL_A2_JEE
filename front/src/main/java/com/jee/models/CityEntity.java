package com.jee.models;

import com.jee.crud.facade.IEntityFacade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "City", schema = "public", catalog = "databaseJEE")
public class CityEntity {
    private String id;
    private String name;
    private String countryId;
    private CountryEntity countryByCountryId;
    private Collection<SensorEntity> sensorsById;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country_id")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, countryId);
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<SensorEntity> getSensorsById() {
        return sensorsById;
    }

    public void setSensorsById(Collection<SensorEntity> sensorsById) {
        this.sensorsById = sensorsById;
    }
}
