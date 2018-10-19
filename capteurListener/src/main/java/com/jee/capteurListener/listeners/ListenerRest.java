package com.jee.capteurListener.listeners;

import com.jee.capteurListener.exception.UnknownNatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerRest {

    @Autowired ListenerService listenerService;

    @PostMapping("/addMesure")
    public void addMesure(@RequestParam() String captorCity) throws UnknownNatureException {

        System.out.println(captorCity);
        //Mesure mesure = listenerService.toDto(city,country,capteurID,nature,date,value);

        // TODO faire la suite.
    }
}
