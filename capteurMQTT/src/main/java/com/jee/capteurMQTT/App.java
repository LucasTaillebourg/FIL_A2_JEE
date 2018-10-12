package com.jee.capteurMQTT;


import com.jee.capteurMQTT.broker.BrokerConnect;
import com.jee.capteurMQTT.broker.RandomMesureCreator;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	while(true) {
    		
    		BrokerConnect.sendMesure(RandomMesureCreator.make());
    	}
    	      
    }
    
   
}
