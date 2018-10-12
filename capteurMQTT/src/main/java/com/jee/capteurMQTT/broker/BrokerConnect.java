package com.jee.capteurMQTT.broker;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class BrokerConnect {
	final private static String TOPIC ="/mesures"; 
	final private static String brokerURL = "tcp://localhost";
	
	/**
	 * Format and sends the message to the  mosquitto client
	 * @param message
	 */
	public static void sendMesure(String message) {
		  String publisherId = UUID.randomUUID().toString();
	        try {
				IMqttClient client = new MqttClient(brokerURL,publisherId);
				MqttConnectOptions options = new MqttConnectOptions();
				options.setAutomaticReconnect(true);
				options.setCleanSession(true);
				options.setConnectionTimeout(10);
				client.connect(options);
				client.publish(TOPIC, formatMessage(message));
				
				
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	 private static MqttMessage formatMessage(String string) {                    
	        byte[] payload = String.format(string)
	          .getBytes();        
	        return new MqttMessage(payload);           
	    }

}
