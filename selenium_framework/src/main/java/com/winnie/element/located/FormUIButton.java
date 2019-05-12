package com.winnie.element.located;

import lombok.Data;

@Data
public class FormUIButton {
	
	private String module;
	private String uiButton;
	private String buttonPath;
	
	@Override
	public String toString() {
		return "FormUIButton [module=" + module + ", uiButton=" + uiButton + ", buttonPath=" + buttonPath + "]";
	}
	
	

}
