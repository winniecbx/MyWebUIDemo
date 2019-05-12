package com.winnie.cbx.page;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VendorPagePageTest {
	LoginPage loginPage;
	 @Test
	  public void exportCurrentFields() throws Exception {
		 VendorPage vendorPage = new VendorPage();
		 vendorPage.exportProjectCurrentFields();
	  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  loginPage = new LoginPage();
	  loginPage.cbxLogin();
  }

  @AfterTest
  public void afterTest() throws Exception {
	  if (loginPage != null) {
		loginPage.cbxLogout();
	}
  }

}
