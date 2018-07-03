package com.automation.utils;

import java.io.IOException;
import java.util.Properties;
 
public class PropertyManager {
	
	private static Properties props;
	
	private PropertyManager(){
		props = new Properties();
		Properties systemProps = System.getProperties();
		
		try {
    		props.load(PropertyManager.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		props.putAll(systemProps);
		
	}
	
	private static PropertyManager propertyManager;
		
	public static PropertyManager getInstance() {
		if (propertyManager==null) {
			propertyManager = new PropertyManager();
		}
		return propertyManager;
	}
	
	public static String getProperty(String key) {
		return getInstance().returnProperty(key);
	}
	
	private String returnProperty(String key){
		return props.getProperty(key);
	}
	
	public static void setProperty(String key, String value){
		getInstance().setNewProperty(key, value);
	}
	
	private void setNewProperty(String key, String value){
		props.setProperty(key, value);
	}

	
	
}