package com.jee.capteurHTTP.regulator;

import com.jee.capteurHTTP.creator.CaptorCreatorService;
import com.jee.capteurHTTP.creator.MesureCreatorService;
import com.jee.capteurHTTP.dto.Captor;
import com.jee.capteurHTTP.dto.Mesure;
import com.jee.capteurHTTP.sender.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegulatorService {

    @Autowired
    private CaptorCreatorService captorCreatorService;
    @Autowired
    private MesureCreatorService mesureCreatorService;
    @Autowired
    private SendService sendService;

    private boolean shouldSend = false;

    public void start() throws InterruptedException {
        shouldSend = true;
        while(shouldSend){
            Captor captor = captorCreatorService.createCaptor();
            Mesure mesure = mesureCreatorService.createMesure();
            try {
                this.sendService.sendPost(captor, mesure);
            } catch (IOException e) {
                System.out.println("Connexion refusée, le serveur d'écoute ne doit pas être démarré :/");
            }
            Thread.sleep(2000);
        }
    }

    public void stop(){
        this.shouldSend = false;
    }
}
