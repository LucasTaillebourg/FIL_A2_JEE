package com.jee.models;

import com.jee.crud.facade.IEntityFacade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "public", catalog = "databaseJEE")
public class UsersEntity implements Serializable {
    private int id;
    private String email;
    private String password;

    private IEntityFacade crudEntityFacade;

    public Collection findPassWordByEmail (String email){
        Map<String, String> queryParameters = new HashMap<>();
        String query = "select password from Users where email = :email";
        queryParameters.put("email", email);
        return crudEntityFacade.customSearch(query,queryParameters);
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password);
    }
}
