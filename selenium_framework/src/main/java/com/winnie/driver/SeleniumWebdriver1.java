package com.winnie.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.winnie.config.MyConfig;

public class SeleniumWebdriver1 {
	Logger logger = Logger.getLogger(SeleniumWebdriver.class);
	private WebDriver driver;

	public SeleniumWebdriver1() {
		
		String path = System.getProperty("user.dir");
		MyConfig myConfig = new MyConfig();
		Object browseType = myConfig.getProperty("browseType");
		if ("Firefox".equals(browseType)) {
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",path + "\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (driver != null) {
			driver.manage().window().maximize();
			logger.info("start open browse "); 
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	

}
