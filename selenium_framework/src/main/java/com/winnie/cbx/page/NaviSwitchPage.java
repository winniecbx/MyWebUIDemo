package com.winnie.cbx.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.winnie.action.BaseAction;
import com.winnie.element.located.BaseElementLocateRule;

public class NaviSwitchPage extends BaseAction {
	Logger logger = Logger.getLogger(NaviSwitchPage.class);
	
	

	public void switchNavi(String located) throws Exception {
		Thread.sleep(5000);//一定要加，要不click不作用
		WebElement productEle = findElement(located);
		logger.info("Navi: " + productEle.getText());
		System.out.println("Product Navi " + productEle.getText());
		moveToElementClick(productEle);
		
		System.out.println("Switch Product Navi");
	}

}
