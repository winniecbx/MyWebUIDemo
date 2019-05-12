package com.winnie.cbx.page;

import org.testng.annotations.Test;

public class ColorPageTest {
	private ColorPage colorPage;
  @Test
  public void createColorDoc() throws Exception {
	  if (colorPage == null) {
		colorPage = new ColorPage();
	  }	
	  colorPage.listingCreateColorDoc();
  }
  
  @Test(dependsOnMethods="createColorDoc", enabled =false)
  public void saveColorDoc() throws Exception {
	  colorPage.colorSave();
  }
}
