package com.winnie.cbx.page;

import org.testng.annotations.Test;

public class DependedGroupsTest {
	
	@Test(groups="server")
	public void test1() {
		System.out.println("group test 1 in " + DependedGroupsTest.class.getName());
	}
	

	@Test(groups="server")
	public void test2() {
		System.out.println("group test 2 in " + DependedGroupsTest.class.getName());
	}

}
