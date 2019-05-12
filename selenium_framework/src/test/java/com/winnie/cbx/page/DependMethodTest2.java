package com.winnie.cbx.page;

import org.testng.annotations.Test;

public class DependMethodTest2 {
	
	@Test(dependsOnMethods={"itemCreateDoc"})
	public void testDependMethod(){
		//测试异常，不能在不同类使用dependsOnMethods
		System.out.println("test depend method in different java class **********************");
	}

}
