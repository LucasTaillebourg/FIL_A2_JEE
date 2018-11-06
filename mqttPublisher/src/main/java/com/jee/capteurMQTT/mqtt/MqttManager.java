package com.jee.capteurMQTT.mqtt;

import java.io.Closeable;
import java.io.IOException;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

import com.jee.capteurMQTT.dto.Measure;

public class MqttManager implements Closeable  {

	private MqttClient client;
	private MqttConnectOptions options;

	final private static String TOPIC = "/mesures";
	final private static String brokerURL = "tcp://172.17.2.34";
	final private static int QoS = 2;
	final private static boolean RETAINED = false;
	final private static int WAIT_TIME = 2000;

	public MqttManager() throws MqttException {
		String publisherId = UUID.randomUUID().toString();
		client = new MqttClient(brokerURL, publisherId);
		options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(false);
		options.setConnectionTimeout(1);
		client.setTimeToWait(WAIT_TIME);
	
	}
	
	public void listenTo(String topic) throws MqttSecurityException, MqttException {
		this.client.connect(options);
		client.subscribe(topic);
	}

	/**
	 * Format and sends the message to the mosquitto client
	 * 
	 * @param message
	 * @throws MqttException
	 * @throws MqttSecurityException
	 */
	public void sendMesure(Measure measure) throws MqttSecurityException, MqttException {
		client.connect(options);
		client.publish(TOPIC, formatMessage(measure), QoS, RETAINED);
		client.disconnect();
		
	}

	/**
	 * Format mesure to be send Jsonly
	 * @param measure
	 * @return
	 */
	private static byte[] formatMessage(Measure measure) {
		MqttMessage message = new MqttMessage();
		JSONObject measureJson = new JSONObject();
		try {
			
			measureJson.put("value", measure.getValue());
			measureJson.put("nature", measure.getNature());
			measureJson.put("date", measure.getDate());
			measureJson.put("sensorId", measure.getSensor().getId());
			measureJson.put("lon", measure.getSensor().getCoordinates().getLongitude());
			measureJson.put("lat", measure.getSensor().getCoordinates().getLatitude());
			measureJson.put("cityId", measure.getSensor().getCity().getId());
			measureJson.put("cityName", measure.getSensor().getCity().getName());
			measureJson.put("countryId", measure.getSensor().getCity().getCountry().getId());
			measureJson.put("countryName", measure.getSensor().getCity().getCountry().getName());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return measureJson.toString().getBytes();
	}

	public void close() throws IOException {
		System.out.println("client is closed");
		try {
			this.client.close();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void disconnect() throws MqttException {
		this.client.disconnect();

	}
	
	public MqttClient getClient() {
		return this.client;
	}


}
