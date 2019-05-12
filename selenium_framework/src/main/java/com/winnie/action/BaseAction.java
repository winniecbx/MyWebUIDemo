package com.winnie.action;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.winnie.driver.SeleniumWebdriver;
import com.winnie.driver.SeleniumWebdriver1;
import com.winnie.element.located.BaseElementLocateRule;

public class BaseAction{
	private static Logger logger = Logger.getLogger(BaseAction.class);
	private static final int DEFAULT_SECONDS = 10;
	public WebDriver driver;
	
	
	
	public BaseAction() {
		this.driver = SeleniumWebdriver.driver;
	}

	public void openBrowse(String url){
		this.driver.get(url);
	}
	
	public void back() {
		logger.info("navigate back");
		this.driver.navigate().back();
	}
	
	public void forward() {
		logger.info("navigate forward");
		this.driver.navigate().forward();
	}
	
	public void quitBrowse() {
		logger.info("browse quit");
		this.driver.quit();
	}
	
	public WebDriverWait webWait(final String selector, int seconds) {
		logger.info("use webDriverwait to find element: " + selector);
		return new WebDriverWait(this.driver, seconds);
//		WebElement webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
//		return webElement;
	}

	public void impWait(int seconds) {
		logger.info("use implicitlywait method");
		this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void getScreenShot() {
		String path = System.getProperty("user.dir") + "\\screenshot\\";
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDateTime localDateTime = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String dateTime = localDateTime.format(fmt);
		
		String fileName = dateTime+ ".png";
		
		File screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(path+fileName));
			logger.error("The screenShot file is saved in " + path+ "\\" + fileName );
		} catch (IOException e) {
			logger.error("The screenShot file cannot be saved in " + path+ "\\" + fileName );
		}
	}
	
public WebElement findElement(String selector) throws Exception{
		
		if(!selector.contains("=>")) {
			throw new InvalidSelectorException("please input the valid selector");
		}
		String[] ele = selector.split("=>");
		String key = ele[0];
		String value = ele[1];
		By by = null;
		switch (key) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "link":
			by = By.linkText(value);
			break;
		case "partialLink":
			by = By.partialLinkText(value);
			break;
		case "tagName":
			by = By.tagName(value);
			break;
		case "className":
			by = By.className(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "cssSelector":
			by = By.cssSelector(value);
			break;
		default:
			logger.error("please input the valid selector");
			throw new InvalidSelectorException("please input the valid selector");
		}
		WebElement element = null;
		try {
			element = webWait(selector, getWaitTime()).until(ExpectedConditions.presenceOfElementLocated(by));
			
		} catch (Exception e) {
//			getScreenShot(value);
			logger.error("find no element for " + selector);
			throw new Exception("find no element for " + selector);
		}
		return element;
	}

public int getWaitTime() {
	return DEFAULT_SECONDS;
}

public void moveToElementClick(WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).click().perform();
}

public void click(String located) throws Exception {
	WebElement element = findElement(located);
	try {
		element.click();
	} catch (Exception e) {
//		getScreenShot(located);
	}
}

public void setValue(String located, String value) throws Exception {
	WebElement element = findElement(located);
	element.clear();
	element.sendKeys(value);
}


public void execute_js(String js) {
	((JavascriptExecutor)driver).executeScript(js);
	logger.info(js + " is excecuted");
}


public void refresh() {
	this.driver.navigate().refresh();
}

public void waitPageLoad(long seconds) throws InterruptedException {
	Thread.sleep(seconds);
	
}

public WebDriver getDriver() {
	return this.driver;
}





}
