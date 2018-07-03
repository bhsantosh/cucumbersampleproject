package com.automation.utils;

import java.io.IOException;
import java.util.Properties;
 
public class CommonProperty {
	
	private static Properties props;
	
	private CommonProperty(){
		props = new Properties();
		Properties systemProps = System.getProperties();
		
		if(System.getProperty("props") == null){			
			try {
	        		props.load(CommonProperty.class.getClassLoader().getResourceAsStream("commonconfig.properties"));
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    	}
    	} 
		
		props.putAll(systemProps);
		
	}
	
	private static CommonProperty commonproperty;
		
	public static CommonProperty getInstance() {
		if (commonproperty==null) {
			commonproperty = new CommonProperty();
		}
		return commonproperty;
	}
	
	public static String getProperty(String key) {
		return getInstance().returnProperty(key);
	}
	
	private String returnProperty(String key){
		return props.getProperty(key);
	}
}