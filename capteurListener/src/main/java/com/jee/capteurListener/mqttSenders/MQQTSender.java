package com.jee.capteurListener.mqttSenders;

import com.jee.capteurMQTT.dto.Measure;
import com.jee.capteurMQTT.mqtt.MqttManager;
import org.springframework.stereotype.Service;

@Service
public class MQQTSender {

    public void send(Measure measure){
        try(MqttManager mqttManager = new MqttManager()){
            mqttManager.sendMesure(measure);
        }catch(Exception ex){
            System.out.println("Echec de l'envoie en MQTT : " +  ex);
        }

    }
}
