package com.winnie.driver;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import com.winnie.element.located.ListUI;
import com.winnie.element.mapper.ListUIMapper;
import com.winnie.util.DataBaseUtil;

public class DBTest {
	
	@Test
	public void getListUI() throws IOException {
		SqlSession sqlSession = DataBaseUtil.getSqlSession();
		ListUI listUiButton = sqlSession.getMapper(ListUIMapper.class).getListUiButton("item", "form","New Item");
		System.out.println(listUiButton);
	}

}
