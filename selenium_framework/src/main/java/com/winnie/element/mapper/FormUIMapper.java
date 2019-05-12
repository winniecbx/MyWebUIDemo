package com.winnie.element.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.winnie.element.located.FormUI;
import com.winnie.element.located.FormUI1;
import com.winnie.element.located.FormUIButton;

public interface FormUIMapper {
	
	public List<FormUI> getFormUI(@Param("module") String module);
	
	public List<FormUI1> getFormUI1(@Param("module") String module);
	
	public FormUIButton getFormButton(@Param("module") String module, @Param("uiButton") String uiButton);

}
