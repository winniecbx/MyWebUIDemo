package com.winnie.cbx.page;

import com.winnie.action.BaseAction;
import com.winnie.cbx.common.CommonFunction;
import com.winnie.element.located.BaseElementLocateRule;

public class VendorPage extends CommonFunction{
	private static String MASTER_NAVI = BaseElementLocateRule.ID +"cbx_52";
public void exportProjectCurrentFields() throws Exception {
		
//		switchNavi(MASTER_NAVI);
		Thread.sleep(5000);//wait page load
		exportCurrentFields();
		
//		Thread.sleep(10000);
		
	}

}
