package com.jee.capteurListener.listeners;

import com.jee.capteurListener.exception.UnknownNatureException;
import com.jee.capteurListener.mqttSenders.MQQTSender;
import com.jee.capteurMQTT.dto.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerRest {

    @Autowired ListenerService listenerService;
    @Autowired MQQTSender mqqtSender;

    @PostMapping("/addMesure")
    public void addMesure(@RequestParam() String captorId, @RequestParam() String captorCity,
                          @RequestParam() String captorCountry, @RequestParam() String captorLat,
                          @RequestParam() String captorLon, @RequestParam() String mesureDate,
                          @RequestParam() String mesureValue, @RequestParam() String mesureType,
                          @RequestParam() String captorCityId, @RequestParam String captorCountryId) throws UnknownNatureException {


        Measure measure = listenerService.toDto(captorCity,captorCountry,captorLat, captorLon, captorId, mesureType, mesureDate, mesureValue, captorCityId, captorCountryId);

        mqqtSender.send(measure);
    }
}