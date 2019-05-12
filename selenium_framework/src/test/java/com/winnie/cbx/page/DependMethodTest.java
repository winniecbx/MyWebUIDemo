package com.winnie.cbx.page;

import org.testng.annotations.Test;

public class DependMethodTest {
	
//	@Test(dependsOnMethods={"D"})
//	public void C(){
//		System.out.println("C");
//	}
//	
//	@Test(dependsOnMethods={"S"})
//	public void F(){
//		System.out.println("F");
//	}
//	@Test
//	public void S(){
//		System.out.println("S");
//	}
//	
//	@Test
//	public void A(){
//		System.out.println("A");
//	}
//	
//	@Test
//	public void D(){
//		System.out.println("D");
//	}
//	
	@Test
	  public void itemCreateDoc(){
		System.out.println("item create doc start &&&&&&&&&&&&&&&&&&&");
	}
	@Test(dependsOnMethods={"itemCreateDoc"})
	  public void itemSaveDoc(){
		System.out.println("item save doc start **********************");
	}
	
	

}
