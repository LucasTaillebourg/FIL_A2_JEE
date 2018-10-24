package com.jee.capteurMQTT;

import java.io.IOException;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.jee.capteurMQTT.broker.RandomMesureCreator;
import com.jee.capteurMQTT.dto.Measure;
import com.jee.capteurMQTT.mqtt.MqttManager;

/**
 * Hello world!
 *
 */
public class App {
	private static int ONE_SEC = 1000;

	public static void main(String[] args) {

		try (MqttManager mqttManager = new MqttManager()) {
			List<Measure> measures;
			while (true) {
				measures = RandomMesureCreator.make();
				for (Measure measure : measures) {
					mqttManager.sendMesure(measure);
					System.out.println("Sending : "+measure);
					Thread.sleep(ONE_SEC);
					
				}
				Thread.sleep(ONE_SEC*10);
			}
		
		} catch (MqttException | IOException ex) {

			ex.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
