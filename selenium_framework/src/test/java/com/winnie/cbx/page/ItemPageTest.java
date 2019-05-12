package com.winnie.cbx.page;

import org.testng.annotations.Test;

import com.winnie.element.located.BaseElementLocateRule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ItemPageTest {
	private static String PRODUCT_NAVI = BaseElementLocateRule.ID +"cbx_e1";
	LoginPage loginPage;
	ItemPage itemPage;
	
//  @Test
//  public void exportCurrentFields() throws Exception {
//	  itemPage = new ItemPage();
//	  itemPage.exportItemCurrentFields();
//  }
//@BeforeMethod()
//public void swithNavi() throws Exception{
//	 if (itemPage == null) {
//		  itemPage = new ItemPage();
//	  }
//	 itemPage.switchNavi(PRODUCT_NAVI);
//}
	
  @Test
  public void itemTypeCreateDoc() throws Exception {
//	  LoginPage loginPage = new LoginPage();
//	  loginPage.cbxLogin();
	  if (itemPage == null) {
		  itemPage = new ItemPage();
	  }
	  
	  System.out.println("item create doc start &&&&&&&&&&&&&&&&&&&");
//	  itemPage.switchNavi(PRODUCT_NAVI);
	  itemPage.listingCreateItemTypeDoc();
	  System.out.println("run itemCreateDoc successfully");
//	  loginPage.cbxLogout();
	  Thread.sleep(3000);
	
}
  @Test(dependsOnMethods="itemTypeCreateDoc", enabled = false)
  public void listingCreateItemTypeDoc2save() throws Exception{
//	  LoginPage loginPage = new LoginPage();
//		loginPage.cbxLogin();
	  System.out.println("item save doc start **********************");
	  if (itemPage == null) {
		  itemPage = new ItemPage();
	  }
	  boolean isSaveSuccess = itemPage.listingCreateItemTypeDoc2save();
	  assertEquals(isSaveSuccess, true);
//	  System.out.println("run itemSaveDoc successfully");
//	  loginPage.cbxLogout();
	  Thread.sleep(3000);
  }
  
//  @BeforeMethod
//  public void login() throws Exception {
//	  loginPage = new LoginPage();
//	  loginPage.cbxLogin();
//	  
//  }
//
//  @AfterMethod
//  public void logout() throws Exception {
//	  if (loginPage != null) {
//		loginPage.cbxLogout();
//		loginPage.quitBrowse();
//	  }
//  }

}
