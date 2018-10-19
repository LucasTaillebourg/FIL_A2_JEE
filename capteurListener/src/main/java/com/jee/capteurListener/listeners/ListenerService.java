package com.jee.capteurListener.listeners;

import com.jee.capteurListener.dto.Location;
import com.jee.capteurListener.dto.Mesure;
import com.jee.capteurListener.dto.NatureEnum;
import com.jee.capteurListener.exception.UnknownNatureException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class ListenerService {

    public Mesure toDto(String city, String country, String capteurID, String nature, Date date, String value) throws UnknownNatureException {
        Location location = Location.builder().city(city).country(country).build();

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

        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        return Mesure.builder().capteurID(capteurID).date(localDateTime).location(location).nature(natureEnum).value(Float.valueOf(value)).build();
    }
}
