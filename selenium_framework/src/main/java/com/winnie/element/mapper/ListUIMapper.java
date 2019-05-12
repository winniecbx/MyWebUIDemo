package com.winnie.element.mapper;

import org.apache.ibatis.annotations.Param;

import com.winnie.element.located.ListUI;

public interface ListUIMapper {

	public ListUI getListUiButton(@Param("module")String module, @Param("uiType")String uiType,@Param("uiButton") String uiButton);
	
}
