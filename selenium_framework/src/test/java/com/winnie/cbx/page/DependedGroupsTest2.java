package com.winnie.cbx.page;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/*
 * 
before group test 3 in com.winnie.cbx.page.DependedGroupsTest2
group test 1 in com.winnie.cbx.page.DependedGroupsTest
group test 2 in com.winnie.cbx.page.DependedGroupsTest
test 4 in com.winnie.cbx.page.DependedGroupsTest2
*
**/


public class DependedGroupsTest2 {
	
	@BeforeGroups("server")
	public void test3() {
		System.out.println("before group test 3 in " + DependedGroupsTest2.class.getName());
	}
	
	@Test(dependsOnGroups="server")
	public void test4() {
		System.out.println("test 4 in " + DependedGroupsTest2.class.getName());
	}

}
