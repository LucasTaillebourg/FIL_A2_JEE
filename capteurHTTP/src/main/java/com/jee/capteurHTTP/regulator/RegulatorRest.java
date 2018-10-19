package com.jee.capteurHTTP.regulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegulatorRest {

    @Autowired
    private RegulatorService regulatorService;

    @GetMapping("/start")
    public void start() throws InterruptedException {
        regulatorService.start();
    }

    @GetMapping("/stop")
    public void stop(){
        regulatorService.stop();
    }
}
