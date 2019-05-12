package com.winnie.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBaseUtil {
	
	public static SqlSession getSqlSession() throws IOException {
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		return session;
	}

}
