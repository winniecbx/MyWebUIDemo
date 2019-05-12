package com.winnie.cbx.page;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
	LoginPage loginPage;
	@BeforeClass
	public void setUp() {
		loginPage = new LoginPage();
	}
  @Test(groups="loginTrue")
  public void login() throws Exception {
	  if (loginPage != null) {
		loginPage.cbxLogin();
	}
  }
  
  @Test(groups="loginOut")
  public void logout() throws Exception {
	  if (loginPage != null) {
		loginPage.cbxLogout();
	}
  }
  
  @AfterClass
  public void tearDown() {
//	  loginPage.quitBrowse();
  }
}
