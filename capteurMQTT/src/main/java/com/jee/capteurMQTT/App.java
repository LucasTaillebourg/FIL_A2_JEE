package com.jee.capteurMQTT;


import com.jee.capteurMQTT.broker.BrokerConnect;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	while(true) {
    		BrokerConnect.sendMesure("");
    	}
    	      
    }
    
   
}
