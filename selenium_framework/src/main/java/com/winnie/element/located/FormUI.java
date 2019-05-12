package com.winnie.element.located;

import lombok.Data;

@Data
public class FormUI {
	
	private String module;
	private Boolean isCommon;
	private String button;
	private Boolean isGrid;
	private String gridButtonPath;
	private String tabPath;
	private String fieldType;
	private String fieldPath;
	private String fieldValue;
	private String searchBarLocated;
	private String firstRowLocated;
	@Override
	public String toString() {
		return "FormUI [module=" + module + ", isCommon=" + isCommon + ", button=" + button + ", isGrid=" + isGrid
				+ ", gridButtonPath=" + gridButtonPath + ", tabPath=" + tabPath + ", fieldType=" + fieldType
				+ ", fieldPath=" + fieldPath + ", fieldValue=" + fieldValue + ", searchBarLocated=" + searchBarLocated
				+ ", firstRowLocated=" + firstRowLocated + "]";
	}
	
	
	

}
