package com.jee.capteurHTTP.creator;

import com.jee.capteurHTTP.dto.Mesure;
import com.jee.capteurHTTP.dto.NatureEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MesureCreatorService {

    public Mesure createMesure(){
        NatureEnum nature;
        LocalDateTime date;
        float value;

        int rand = (int) Math.ceil(Math.random() * 3);

        switch (rand){
            case 1 : nature = NatureEnum.ATMOSPHERIC_PRESSURE; break;
            case 2 : nature = NatureEnum.TEMPERATURE; break;
            case 3 : nature = NatureEnum.WIND_SPEED; break;
            default: nature = NatureEnum.WIND_SPEED;
        }

        date = LocalDateTime.now();

        value = (float) Math.ceil(Math.random() * 100);

        return Mesure.builder().date(date).nature(nature).value(value).build();
    }
}
