package com.jee.capteurMQTT;


import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.jee.capteurMQTT.broker.RandomMesureCreator;
import com.jee.mqtt.MqttManager;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {

    		//MqttManager mqttManager;
    		try(MqttManager mqttManager = new MqttManager()){// = new MqttManager()
//    	    	while(true) {
    			//todo envoie de message toutes les 10 sec
    			//mqttManager.sendMesure(RandomMesureCreator.make());
    		}catch(MqttException | IOException ex){
    			//todo
    		}
    		
    		


    	      
    }
    
   
}
