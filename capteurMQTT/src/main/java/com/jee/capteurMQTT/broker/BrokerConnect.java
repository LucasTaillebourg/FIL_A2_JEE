package com.jee.capteurMQTT.broker;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONException;
import org.json.JSONObject;

import com.jee.capteurMQTT.dto.Measure;

public class BrokerConnect {
	final private static String TOPIC ="/mesures"; 
	final private static String brokerURL = "tcp://localhost";
	
	/**
	 * Format and sends the message to the  mosquitto client
	 * @param message
	 */
	public static void sendMesure(Measure measure) {
		String publisherId = UUID.randomUUID().toString();
		try {
			IMqttClient client = new MqttClient(brokerURL, publisherId);
			MqttConnectOptions options = new MqttConnectOptions();
			options.setAutomaticReconnect(true);
			options.setCleanSession(true);
			options.setConnectionTimeout(10);
			client.connect(options);
			client.publish(TOPIC, formatMessage(measure));

		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static MqttMessage formatMessage(Measure measure) {
		MqttMessage message = new MqttMessage();
		JSONObject measureJson = new JSONObject();
		try {
			measureJson.put("value", measure.getValue());
			measureJson.put("nature", measure.getNature());
			measureJson.put("date", measure.getDate());
			measureJson.put("sensor", measure.getSensor().getId());
			measureJson.put("city", measure.getSensor().getCity().getId());
			measureJson.put("country", measure.getSensor().getCity().getCountry().getId());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		message.setPayload(measureJson.toString().getBytes());
		return message;
	}
}
