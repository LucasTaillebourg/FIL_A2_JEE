package com.jee.subscriberBDD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.City;
import modele.Country;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscriberBDD");
        
        EntityManager em = emf.createEntityManager();
        Country country = em.find(Country.class, "FR");
        City city = country.getCities().get(0);


        em.getTransaction().begin();
        country.setName("IBRAHIM");
        city.setName("Zbrarazrharazr");
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
