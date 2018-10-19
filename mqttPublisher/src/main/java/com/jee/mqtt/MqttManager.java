package com.jee.mqtt;

import java.io.Closeable;
import java.io.IOException;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

import com.jee.dto.Measure;

public class MqttManager implements Closeable {

	private IMqttClient client;
	private MqttConnectOptions options;

	final private static String TOPIC = "/mesures";
	final private static String brokerURL = "tcp://172.17.2.196";
	final private static int QoS = 2;
	final private static boolean RETAINED = false;

	public MqttManager() throws MqttException {
		String publisherId = UUID.randomUUID().toString();
		client = new MqttClient(brokerURL, publisherId);
		options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(false);
		options.setConnectionTimeout(10);
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
			// TODO mettre a jour le leu de donnés
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

		return measureJson.toString().getBytes();
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

}
