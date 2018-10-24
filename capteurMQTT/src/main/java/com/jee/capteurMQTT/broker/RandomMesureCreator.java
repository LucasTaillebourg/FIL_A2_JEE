package com.jee.capteurMQTT.broker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.jee.capteurMQTT.definitions.Nature;
import com.jee.capteurMQTT.definitions.Sensors;
import com.jee.capteurMQTT.dto.Counrty;
import com.jee.capteurMQTT.dto.Measure;
import com.jee.capteurMQTT.dto.Sensor;

public class RandomMesureCreator {
	
	public static float MIN_TEMP = -10;
	public static float MAX_TEMP = 100;
	public static float MIN_PRES = 200;
	public static float MAX_PRES = 1500;
	public static float MIN_WS = 0;
	public static float MAX_WS = 300;
	
	public static float MIN_WD = 0;
	public static float MAX_WD = 4;
	
	
	public static List<Measure> make() {
		Sensor sensor = Sensors.getSensor();
		Random rand = new Random();
		
		List<Measure> allMeasure = new ArrayList<>();
		
		float randomFloat = MIN_TEMP + rand.nextFloat() * (MAX_TEMP - MIN_TEMP);
		allMeasure.add(new Measure(sensor,Nature.TEMPERATURE,randomFloat,LocalDateTime.now()));
		
		randomFloat = MIN_PRES + rand.nextFloat() * (MAX_PRES - MIN_PRES);
		allMeasure.add(new Measure(sensor,Nature.ATMOSPHERIC_PRESSURE,randomFloat,LocalDateTime.now()));
		
		randomFloat = MIN_WS + rand.nextFloat() * (MAX_TEMP - MIN_WS);
		allMeasure.add(new Measure(sensor,Nature.WIND_SPEED,randomFloat,LocalDateTime.now()));
		
		randomFloat = MIN_WD + rand.nextInt() * (MAX_WD - MIN_WD);
		allMeasure.add(new Measure(sensor,Nature.WIND_DIRECTION,randomFloat,LocalDateTime.now()));
		
		
		return allMeasure;
		
	}

}
