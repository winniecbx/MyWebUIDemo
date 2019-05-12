package com.winnie.cbx.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.winnie.action.BaseAction;
import com.winnie.cbx.common.CommonFunction;
import com.winnie.element.located.BaseElementLocateRule;

public class LoginPage extends CommonFunction {
// https://qa-cbx5.coresolutions.com/main/login.jsp
	private Logger logger = Logger.getLogger(LoginPage.class);
	private static int waitLoadTime = 10;
	private static final String LOCAL_URL= "http://localhost:8086/main/login.jsp";
	private static final String CBX_RUL = "https://qa-cbx5.coresolutions.com/main/login.jsp";
	String url = "https://qa-cbx5.coresolutions.com/main/invalidatePrevSession.jsp#DEFAULT";
	public void cbxLogin() throws Exception {
		openBrowse(CBX_RUL);
		
		
		WebElement userName = findElement(BaseElementLocateRule.ID +"username");
		userName.clear();
		userName.sendKeys("winnie_second");
		WebElement pwd = findElement(BaseElementLocateRule.ID +"password");
		pwd.clear();
		pwd.sendKeys("core@123");
		WebElement loginbutton = findElement(BaseElementLocateRule.ID +"submit");
		loginbutton.click();
		System.out.println("%%%%  " + driver.getCurrentUrl() + "  %%%%%%");
		if (url.equals(driver.getCurrentUrl())) {
			WebElement loginAnyway = findElement(BaseElementLocateRule.XPATH +"/html/body/form/div/div[3]/input[1]");
			loginAnyway.click();
		}
		
	}
	
	public void cbxLogout() throws Exception {
		Thread.sleep(10000);
		try {
//			WebElement popUpwin = findElement(BaseElementLocateRule.XPATH+ "//*[contains(@class, 'z-window-modal z-window-shadow')]");
			WebElement popupCloseBtn = findElement(BaseElementLocateRule.XPATH+ "//*[contains(@class, 'z-window-icon z-window-close')]");
			if (popupCloseBtn.isDisplayed()) {
				popupCloseBtn.click();
				waitPageLoad(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		clickLogout();
		waitPageLoad(2000);
		closeWarningMsgPopup();
		
//		try {
//			WebElement okEle = findElement(BaseElementLocateRule.XPATH+ ".//*[text()='OK']");
//			if (okEle != null) {
//				okEle.click();
//			}
//		} catch (Exception e) {
//		}
		}

	private void clickLogout() throws Exception {
		WebElement logoutImage = findElement(BaseElementLocateRule.ID +"cbx__imageDownBtn");
		Actions action = new Actions(driver);
		action.moveToElement(logoutImage).click().perform();
		//cbx__logoutTxtBtn
		WebElement logout = findElement(BaseElementLocateRule.ID +"cbx__logoutTxtBtn");
		logout.click();
	}
			// TODO: handle exception

	@Override
	public int getWaitTime() {
		return waitLoadTime;
	}
	
	
}
