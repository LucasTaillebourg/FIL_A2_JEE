package com.jee.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.jee.crud.CRUDEntityFacade;
import com.jee.crud.facade.IEntityFacade;

/**
 * The persistent class for the "Users" database table.
 * 
 */
@Entity
@Table(name = "\"Users\"", schema="\"public\"")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") })

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "USERS_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
	private Integer id;

	private String email;

	private String password;
	
	private IEntityFacade crudEntityFacade = new CRUDEntityFacade<>();

	public User() {
	}
	
	public Collection findPassWordByEmail (String email){
        Map<String, String> queryParameters = new HashMap<>();
        String query = "select user.password from User user where user.email = :email";
        queryParameters.put("email", email);
        return crudEntityFacade.customSearch(query,queryParameters);
    }

    public User findById(int idSensor){
        return (User)crudEntityFacade.read(User.class, idSensor);
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}