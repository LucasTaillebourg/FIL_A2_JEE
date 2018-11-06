package com.jee.models;

import java.io.Serializable;
import javax.persistence.*;

import com.jee.crud.CRUDEntityFacade;
import com.jee.crud.facade.IEntityFacade;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * The persistent class for the "Measure" database table.
 * 
 */
@Entity
@Table(name="\"Measure\"", schema="\"public\"")
@NamedQuery(name="Measure.findAll", query="SELECT m FROM Measure m")
public class Measure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASURE_ID_GENERATOR", sequenceName="MEASURE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURE_ID_GENERATOR")
	private int id;

	private Timestamp date;

	private String nature;

	private double value;
	
	@Transient
	private IEntityFacade crudEntityFacade = new CRUDEntityFacade<>();
	
	/**
	 * fetch all Measures for
	 * @param nature that start at
	 * @param startDate and finish at
	 * @param endDate
	 * @return Measures
	 */
	public Collection findMeasures(String nature, Timestamp startDate, Timestamp endDate){
        Map<String, String> queryParameters = new HashMap<>();
        String query = "select m from Measure m where m.nature = :nature AND m.date >= :startDate AND m.date <= :endDate";
        queryParameters.put("nature", nature.toString());
        queryParameters.put("date", startDate.toString());
        queryParameters.put("date", endDate.toString());
        return crudEntityFacade.customSearch(query,queryParameters);
    }
	
	/**
	 * fetch all Measures for
	 * @param nature that start at
	 * @param startDate and finish at
	 * @param endDate
	 * @return Measures
	 */
	public Collection findAlertes(Alerte alerte, Timestamp startDate, Timestamp endDate){
        Map<String, String> queryParameters = new HashMap<>();
        String query = "select m from Measure m where m.nature = '"+ alerte.getType() +"' AND m.value "+ alerte.getOperande() +" '"+ alerte.getSeuil() +"' AND m.date >= '"+startDate.toString()+"' AND m.date <= '"+endDate.toString()+"'";
        //queryParameters.put("nature", alerte.getType().toString());
        //queryParameters.put("value", alerte.getSeuil());
        return crudEntityFacade.customSearch(query,queryParameters);
    }

	
	/*SELECT nature, date, value, sensor_id, id
	FROM public."Measure" where nature='TEMPERATURE' AND value > 30 AND date > '2018-11-06 13:30:15.000';*/
	
	//bi-directional many-to-one association to Sensor
	@ManyToOne
	private Sensor sensor;

	public Measure() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}