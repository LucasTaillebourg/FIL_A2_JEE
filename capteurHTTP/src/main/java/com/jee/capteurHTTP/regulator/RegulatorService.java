package com.jee.capteurHTTP.regulator;

import com.jee.capteurHTTP.creator.CaptorCreatorService;
import com.jee.capteurHTTP.creator.MesureCreatorService;
import com.jee.capteurHTTP.dto.Captor;
import com.jee.capteurHTTP.dto.Mesure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegulatorService {

    @Autowired
    private CaptorCreatorService captorCreatorService;
    @Autowired
    private MesureCreatorService mesureCreatorService;

    private boolean shouldSend = false;

    public void start() throws InterruptedException {
        shouldSend = true;
        while(shouldSend){
            Thread.sleep(10000);
            Captor captor = captorCreatorService.createCaptor();
            Mesure mesure = mesureCreatorService.createMesure();
        }
    }

    public void stop(){
        this.shouldSend = false;
    }
}
