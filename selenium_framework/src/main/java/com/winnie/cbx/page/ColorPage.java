package com.winnie.cbx.page;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.winnie.cbx.common.CommonFunction;
import com.winnie.element.located.FormUI1;
import com.winnie.element.mapper.FormUIMapper;
import com.winnie.util.DataBaseUtil;

public class ColorPage extends CommonFunction {
	
	public void listingCreateColorDoc() throws Exception {
		switchNavi("Products", "Colors", "Active");
//		createDoc("Create", "New Color");
		
	}
	
	public void colorSave() throws Exception {
		collapseRHP();
		waitPageLoad(2000);
		SqlSession sqlSession = DataBaseUtil.getSqlSession();
		List<FormUI1> formUIs = sqlSession.getMapper(FormUIMapper.class).getFormUI1("color");
		fillFormAllFieldsValue("", formUIs);
	}

}
