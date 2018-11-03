package com.jee.subscriberBDD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.eclipse.paho.client.mqttv3.MqttException;

//import com.jee.capteurMQTT.mqtt.MqttManager;

import modele.City;
import modele.Country;
import modele.User;

public class App {
	public static void main(String[] args) {
		
//		try {
//			MqttManager manager = new MqttManager();
//			CallbackManager cbManager = new CallbackManager();
//			manager.listenTo("/mesures", cbManager);
//		} catch (MqttException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("subscriberBDD");

		EntityManager em = emf.createEntityManager();
		
		User user = new User();
		em.getTransaction().begin();
		/**user.setEmail("aa");
		user.setPassword("bb");
		em.getTransaction().commit();
		*/
		
		boolean enMarche = true;

//		while (enMarche) {
			Country country = em.find(Country.class, "FR");
			City city = country.getCities().get(0);
//
			em.getTransaction().begin();
			country.setName("IBRAHIM");
			city.setName("Zbrarazrharazr");
			em.getTransaction().commit();
//		}

		em.close();
		emf.close();
		
	}
}
