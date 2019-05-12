package com.winnie.element.located;

import lombok.Data;

@Data
public class FormUI1 {
	
	private String module;
	private String tab;
	private Boolean isCommon;
	private String button;
	private Boolean isGrid;
	private String grid;
	private String gridButton;
	private String fieldType;
	private String fieldLabel;
	private String winTitle;
	private String value;
	
	@Override
	public String toString() {
		return "FormUI1 [module=" + module + ", tab=" + tab + ", isCommon=" + isCommon + ", button=" + button
				+ ", isGrid=" + isGrid + ", grid=" + grid + ", gridButton=" + gridButton + ", fieldType=" + fieldType
				+ ", fieldLabel=" + fieldLabel + ", winTitle=" + winTitle + ", value=" + value + "]";
	}
	
	
	

}

