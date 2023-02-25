package org.irctc.logs;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class IrctcLogs {
	
	public static Logger irctclLogger(Class<?> pClass) {
		Logger log = Logger.getLogger(pClass);
		
		// we can have log4j.xml or log4j.properties files for configuration
		PropertyConfigurator.configure("D:\\projects\\org-irctc-testng\\src\\test\\resources\\log4j.properties");
		
		return log;
	}

}
