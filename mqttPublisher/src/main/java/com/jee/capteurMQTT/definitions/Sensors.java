package com.jee.capteurMQTT.definitions;

import java.util.ArrayList;
import java.util.List;

import com.jee.capteurMQTT.dto.City;
import com.jee.capteurMQTT.dto.Counrty;
import com.jee.capteurMQTT.dto.GeoCoordinate;
import com.jee.capteurMQTT.dto.Sensor;

public class Sensors {
	private static int it = 0;
	private static City city = new City("NTE","Nantes",new Counrty("FR", "France"));
	private static List<Sensor> sensors = new ArrayList<Sensor>() {{
	    add(new Sensor(1,city,new GeoCoordinate(47.283472,-1.5216897)));
	    add(new Sensor(2,city,new GeoCoordinate(47.281456,-1.5198227)));
	    add(new Sensor(3,city,new GeoCoordinate(47.282589,-1.5215892)));
	    add(new Sensor(4,city,new GeoCoordinate(47.281258,-1.5202588)));
	    add(new Sensor(5,city,new GeoCoordinate(47.283258,-1.5219875)));
	    add(new Sensor(6,city,new GeoCoordinate(47.282589,-1.5225896)));
	    
	}};
	
	
	public static Sensor getSensor() {
		if(it < 5) it++;
		else it=0;
		return sensors.get(it);
	}
	
	
	

}
