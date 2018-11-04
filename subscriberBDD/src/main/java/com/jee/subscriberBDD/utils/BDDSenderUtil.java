package com.jee.subscriberBDD.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jee.subscriberBDD.modele.City;
import com.jee.subscriberBDD.modele.Country;
import com.jee.subscriberBDD.modele.Measure;
import com.jee.subscriberBDD.modele.Sensor;

public class BDDSenderUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscriberBDD");

	private static EntityManager em = emf.createEntityManager();

	public static void sendMeasureToDatabase(Measure measure) {
		Country countryDb = em.find(Country.class, measure.getSensor().getCity().getCountry().getId());
		City cityDb = em.find(City.class, measure.getSensor().getCity().getId());
		Sensor sensorDb = em.find(Sensor.class, measure.getSensor().getId());
		em.getTransaction().begin();
		if (countryDb != null) {
			if (cityDb == null) {
				em.persist(measure.getSensor().getCity());
			} 
			if (sensorDb == null) {
				em.persist(measure.getSensor());
			}
		} else {

			em.persist(measure.getSensor().getCity().getCountry());
			em.persist(measure.getSensor().getCity());
			em.persist(measure.getSensor());

		}
		em.persist(measure);
		em.getTransaction().commit();
	}

}
