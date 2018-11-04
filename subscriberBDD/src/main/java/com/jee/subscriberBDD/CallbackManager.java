package com.jee.subscriberBDD;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import com.jee.subscriberBDD.modele.City;
import com.jee.subscriberBDD.modele.Country;
import com.jee.subscriberBDD.modele.Measure;
import com.jee.subscriberBDD.modele.Sensor;
import com.jee.subscriberBDD.utils.BDDSenderUtil;

public class CallbackManager implements MqttCallback{

	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		JSONObject obj = new JSONObject(message.toString());
		Country country = new Country();
		country.setId(obj.getString("countryId"));
		country.setName(obj.getString("countryName"));
		
		City city = new City();
		city.setCountry(country);
		city.setId(obj.getString("cityId"));
		city.setName(obj.getString("cityName"));
		Sensor sensor = new Sensor();
		sensor.setCity(city);
		sensor.setLatitude(BigDecimal.valueOf(obj.getDouble("lat")));
		sensor.setLongitude(BigDecimal.valueOf(obj.getDouble("lon")));
		sensor.setId(Long.valueOf(obj.getInt("sensorId")));
		Measure measure = new Measure();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		LocalDateTime date = LocalDateTime.parse(obj.getString("date"), formatter);
		measure.setDate(Timestamp.valueOf(date));
		measure.setNature(obj.getString("nature"));
		measure.setSensor(sensor);
		measure.setValue(new Float(obj.getDouble("value")));
		BDDSenderUtil.sendMeasureToDatabase(measure);
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}

}
