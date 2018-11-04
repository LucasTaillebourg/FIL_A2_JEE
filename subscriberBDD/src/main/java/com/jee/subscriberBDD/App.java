package com.jee.subscriberBDD;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jee.subscriberBDD.modele.City;
import com.jee.subscriberBDD.modele.Country;
import com.jee.subscriberBDD.modele.Measure;
import com.jee.subscriberBDD.modele.Sensor;
import com.jee.subscriberBDD.modele.User;
import com.jee.subscriberBDD.utils.BDDSenderUtil;

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
		
		
		Measure measure = new Measure();
		measure.setDate(Timestamp.valueOf(LocalDateTime.now()));
		measure.setNature("ATHMOSPHERIQUE");
		measure.setValue(1.25);
		Sensor sensor = new Sensor();
		sensor.setId(new Long("98"));
		sensor.setLatitude(new BigDecimal("15151515"));
		sensor.setLongitude(new BigDecimal("115"));
		City city  = new City();
		city.setId("PR");
		city.setName("Prout");
		Country country =new Country();
		country.setId("dedede");
		country.setName("aaaaa");
		city.setCountry(country);
		sensor.setCity(city);
		measure.setSensor(sensor);
		measure.setSensor(sensor);
		
		BDDSenderUtil.sendMeasureToDatabase(measure);
		
	}
}
