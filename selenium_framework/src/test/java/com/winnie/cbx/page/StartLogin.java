package com.winnie.cbx.page;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class StartLogin {
	LoginPage login;
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  login = new LoginPage();
	  login.cbxLogin();
	  Thread.sleep(10000);
  }

  @AfterTest
  public void afterTest() throws Exception {
	  if (login != null) {
		login.cbxLogout();
//		login.quitBrowse();
	  }
  }

}
