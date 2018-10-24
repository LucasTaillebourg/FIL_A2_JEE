package com.jee.capteurListener.listeners;

import com.jee.capteurListener.exception.UnknownNatureException;
import com.jee.capteurMQTT.definitions.Nature;
import com.jee.capteurMQTT.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ListenerService {

    public Measure toDto(String city, String country, String lat, String lon, String capteurID, String nature, String date, String value, String captorCityId, String captorCountryId) throws UnknownNatureException {
        Nature natureFinal;

        switch(nature.toLowerCase()){
            case "temperature" :
                natureFinal = Nature.TEMPERATURE;
                break;
            case "atmospheric_pressure" :
                natureFinal = Nature.ATMOSPHERIC_PRESSURE;
                break;
            case "wind_speed" :
                natureFinal = Nature.WIND_SPEED;
                break;
            default :
                throw new UnknownNatureException(nature);
        }

        GeoCoordinate coordinate = new GeoCoordinate(Double.valueOf(lat), Double.valueOf(lon));

        Counrty countryObj = new Counrty();
        countryObj.setId(captorCountryId);
        countryObj.setName(country);

        City cityObj = new City();
        cityObj.setId(captorCityId);
        cityObj.setName(city);
        cityObj.setCountry(countryObj);

        Sensor sensor = new Sensor();
        sensor.setId(Integer.valueOf(capteurID));
        sensor.setCoordinates(coordinate);
        sensor.setCity(cityObj);

        Measure measure = new Measure();
        measure.setDate(LocalDateTime.parse(date));
        measure.setNature(natureFinal);
        measure.setValue(Float.valueOf(value));
        measure.setSensor(sensor);

        return measure;
    }
}