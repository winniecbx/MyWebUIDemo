package com.winnie.element.located;

import lombok.Data;

@Data
public class ListUI {
	
	private String module;
	private String naviPath;
	private String uiType;
	private String uiButton;
	private String uiButtonPath;
	@Override
	public String toString() {
		return "ListUI [module=" + module + ", naviPath=" + naviPath + ", uiType=" + uiType + ", uiButton=" + uiButton
				+ ", uiButtonPath=" + uiButtonPath + "]";
	}
	
	
}
