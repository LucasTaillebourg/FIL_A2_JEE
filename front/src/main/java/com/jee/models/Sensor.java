package com.jee.models;

import java.io.Serializable;
import javax.persistence.*;

import com.jee.crud.CRUDEntityFacade;
import com.jee.crud.facade.IEntityFacade;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the "Sensor" database table.
 * 
 */
@Entity
@Table(name="\"Sensor\"", schema="\"public\"")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private BigDecimal latitude;

	private BigDecimal longitude;
	
	
	
	@Transient
	private IEntityFacade crudEntityFacade = new CRUDEntityFacade<>();
	
	/**
	 * fetch all sensors from data base
	 * @return sensors
	 */
	public Collection findAllSensors (){
        Map<String, String> queryParameters = new HashMap<>();
        String query = "select s from Sensor s";
        return crudEntityFacade.customSearch(query,null);
    }

	//bi-directional many-to-one association to Measure
	@OneToMany(mappedBy="sensor")
	private List<Measure> measures;

	//bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	public Sensor() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setSensor(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setSensor(null);

		return measure;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public String getDetail() {
		return "Temperature moyenne : 25, Pression Moyenne : 10, Vent: 5km/h, ouest"; 
	}

}