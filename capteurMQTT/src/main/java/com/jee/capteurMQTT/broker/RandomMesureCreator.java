package com.jee.capteurMQTT.broker;

import java.util.Locale;

import com.jee.capteurMQTT.dto.Counrty;
import com.jee.capteurMQTT.dto.Measure;

public class RandomMesureCreator {
	
	public static Measure make() {
		Counrty country = new Counrty();
		country.setId(Locale.FRANCE.toString());
		
		
		return null;
		
	}

}
