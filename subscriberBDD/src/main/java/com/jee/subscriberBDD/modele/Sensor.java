package com.jee.subscriberBDD.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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

}