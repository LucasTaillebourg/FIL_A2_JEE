package com.jee.bean.alertes;

import java.time.LocalDateTime;

public class AlerteBean {

    String intitule;
    String type;
    String seuil;
    String operator;
    String gravite;
    
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeuil() {
        return seuil;
    }

    public void setSeuil(String seuil) {
        this.seuil = seuil;
    }

    public String getGravite() {
        return gravite;
    }

    public void setGravite(String gravite) {
        this.gravite = gravite;
    }


    
    
}
