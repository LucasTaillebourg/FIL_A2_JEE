package com.jee.capteurListener.listeners;

import com.jee.capteurListener.dto.Mesure;
import com.jee.capteurListener.exception.UnknownNatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ListenerRest {

    @Autowired ListenerService listenerService;

    @GetMapping("/addMesure")
    public void addMesure(@RequestBody String city, @RequestBody String country, @RequestBody String capteurID, @RequestBody String nature, @RequestBody Date date, @RequestBody String value) throws UnknownNatureException {

        Mesure mesure = listenerService.toDto(city,country,capteurID,nature,date,value);

        // TODO faire la suite.
    }
}
