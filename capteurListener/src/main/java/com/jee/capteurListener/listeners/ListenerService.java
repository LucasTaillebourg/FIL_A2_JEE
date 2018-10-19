package com.jee.capteurListener.listeners;

import com.jee.capteurListener.dto.Location;
import com.jee.capteurListener.dto.Mesure;
import com.jee.capteurListener.dto.NatureEnum;
import com.jee.capteurListener.exception.UnknownNatureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ListenerService {

    public Mesure toDto(String city, String country, String lat, String lon, String capteurID, String nature, String date, String value) throws UnknownNatureException {
        Location location = Location.builder().city(city).country(country).lat(lat).lon(lon).build();

        NatureEnum natureEnum;

        switch(nature.toLowerCase()){
            case "temperature" :
                natureEnum = NatureEnum.TEMPERATURE;
                break;
            case "atmospheric_pressure" :
                natureEnum = NatureEnum.ATMOSPHERIC_PRESSURE;
                break;
            case "wind_speed" :
                natureEnum = NatureEnum.WIND_SPEED;
                break;
            default :
                throw new UnknownNatureException(nature);
        }

        return Mesure.builder().capteurID(capteurID).date(LocalDateTime.parse(date)).location(location).nature(natureEnum).value(Float.valueOf(value)).build();
    }
}