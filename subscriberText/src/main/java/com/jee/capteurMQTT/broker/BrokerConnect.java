package com.jee.capteurMQTT.broker;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class BrokerConnect {
	final private static String TOPIC ="/mesures"; 
	final private static String brokerURL = "tcp://localhost";
	
	/**
	 * 
	 * @param message
	 * @throws MqttException 
	 */
	public static void getMesure() throws MqttException {
		String publisherId = UUID.randomUUID().toString();
		IMqttClient client = new MqttClient(brokerURL,publisherId);
		Object receivedSignal;
		client.subscribe(TOPIC);
		
	}
	


}
