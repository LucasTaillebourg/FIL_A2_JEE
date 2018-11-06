package com.jee.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jee.crud.CRUDEntityFacade;
import com.jee.crud.facade.IEntityFacade;


/**
 * The persistent class for the "Alertes" database table.
 * 
 */
@Entity
@Table(name="\"Alertes\"", schema="\"public\"")
@NamedQuery(name="Alerte.findAll", query="SELECT a FROM Alerte a")
public class Alerte implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gravite;

	@Id
	@SequenceGenerator(name="ALERTES_ID_GENERATOR", sequenceName="ALERTES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERTES_ID_GENERATOR")
	private int id;

	private String intitule;

	private String operande;

	private String seuil;
	
	private String type;
	
	@Transient 
	private IEntityFacade crudEntityFacade = new CRUDEntityFacade<>();

	public Alerte() {
	}
	
	public Collection getAllAlertes() {
        Map<String, String> queryParameters = new HashMap<>();
        String query = "SELECT a FROM Alerte a";
        return crudEntityFacade.customSearch(query,queryParameters);
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGravite() {
		return this.gravite;
	}

	public void setGravite(String gravite) {
		this.gravite = gravite;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getOperande() {
		return this.operande;
	}

	public void setOperande(String operande) {
		this.operande = operande;
	}

	public String getSeuil() {
		return this.seuil;
	}

	public void setSeuil(String seuil) {
		this.seuil = seuil;
	}

}