 package com.automation.utils;

import org.apache.log4j.Logger;

public class Log {
	//Initialize Log4j logs
	 private static Logger Log = Logger.getLogger(Log.class.getName());
	 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	 
	 public static void startTestCase(){
		 Log.info("" + "\n");
		 Log.info("$$$$$$$$$$$$$$$$$$$$$$$    "+ "-S-T-A-R-T-" + "    $$$$$$$$$$$$$$$$$$$$$$$" + "\n");
		 Log.info("" + "\n");
		 }
	 
	 //This is to print log for the ending of the test case
	 public static void endTestCase(){
		 Log.info("" + "\n");
		 Log.info("XXXXXXXXXXXXXXXXXXXXXXX    "+"-E--N--D-"+"    XXXXXXXXXXXXXXXXXXXXXX" + "\n");
		 Log.info("" + "\n");
		 }
	
	 // Need to create these methods, so that they can be called  
	 public static void info(String message) {
		 //("");
		 Log.info(message + "\n");
		 }

	 public static void warn(String message) {
		 Log.warn(""+ "\n");
		 Log.warn(message + "\n");
		 Log.warn(""+ "\n");
		 }

	 public static void error(String message) {
		 Log.error("\t\t??????????   " + message + "   ??????????" + "\n");
		}

	 public static void fatal(String message) {
		 Log.fatal(message + "\n");
		 }

	 public static void debug(String message) {
		 Log.debug(message + "\n");
		 }
	 
	 public static void highlight(String message) {
		 Log.info("\t\t???????????????????????????????????????????????????????????" + "\n");
		 Log.info("\t\t????                                                   ????" + "\n");
		 Log.info("\t\t\t\t"+ message + "\n");
		 Log.info("\t\t????                                                   ????" + "\n");
		 Log.info("\t\t???????????????????????????????????????????????????????????" + "\n");
		 }
	 
	 public static void loading(String message) {
		 Log.info(message);
	}
}