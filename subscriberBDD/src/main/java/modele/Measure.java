package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private String id;

	private Timestamp date;

	private String nature;

	private double value;

	//bi-directional many-to-one association to Sensor
	@ManyToOne
	private Sensor sensor;

	public Measure() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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