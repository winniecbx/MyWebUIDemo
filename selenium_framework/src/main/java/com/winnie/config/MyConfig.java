package com.winnie.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class MyConfig {
	public static Logger logger = Logger.getLogger(MyConfig.class);
	static Properties properties = new Properties();
	public MyConfig() {
		init();
	}
	
	public static void init() {
		String path = System.getProperty("user.dir");
		try {
			FileInputStream is = new FileInputStream(new File(path + "/src/test/resources/configures/browseType.properties"));
			FileInputStream log4jIs = new FileInputStream( new File(path + "/src/test/resources/configures/log4j.properties"));
			properties.load(is);
			
			properties.load(log4jIs);
			PropertyConfigurator.configure(properties);
		} catch (FileNotFoundException e) {
			logger.error("No browseType file", e);
		} catch (IOException e) {
			logger.error("read file error", e);
		}
	}
	
	public Object getProperty(String key){
		return properties.get(key);
	}
	
	@Test
	public void test1() {
		MyConfig myConfig = new MyConfig();
		System.out.println("browsetype is " + myConfig.getProperty("browseType"));
	}

}
