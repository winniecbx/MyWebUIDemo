package com.winnie.cbx.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.javassist.compiler.ast.StringL;
import org.apache.ibatis.javassist.tools.framedump;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.gherkin.model.And;
import com.winnie.action.BaseAction;
import com.winnie.element.located.BaseElementLocateRule;
import com.winnie.element.located.FormUI;
import com.winnie.element.located.FormUI1;

public class CommonFunction extends BaseAction{
	Logger logger = Logger.getLogger(CommonFunction.class);
	public void exportCurrentFields() throws Exception {
		WebElement exportEle = findElement(BaseElementLocateRule.ID +"cbx_mainWin_export-a");
		exportEle.click();
//		//*[@id="cbx_mainWin_searchViewCurExport-a"]
		WebElement exportCurFieldEle = findElement(BaseElementLocateRule.ID +"cbx_mainWin_searchViewCurExport-a");
		exportCurFieldEle.click();
		logger.info("export current fields successfully");
	}
	
	public void switchNavi(String navi, String naviEntryGroup, String naviEntry) throws Exception {
		Thread.sleep(10000);//一定要加，要不click不作用
		String naviLocated = "xpath=>//*[text()= '" + navi + "']";
		WebElement productEle = findElement(naviLocated);
		
		logger.info("Navi: " + productEle.getText());
		System.out.println(" Navi " + productEle.getText());
		moveToElementClick(productEle);
		waitPageLoad(8000);
//		WebElement naviEntryEle = findElement(naviEntry);
		String naviEntryGroupImageLocated = "xpath=>//*[text()= '" + naviEntryGroup + "']/img";
		WebElement imgEle = findElement(naviEntryGroupImageLocated);
		boolean isExpand = false;
		if (imgEle != null) {
			isExpand= imgEle.getAttribute("src").contains("down");
		}
		String naviEntryGroupLocated = "xpath=>//*[text()= '" + naviEntryGroup + "']";
		if (BooleanUtils.isFalse(isExpand)) {
			click(naviEntryGroupLocated);
		}
		waitPageLoad(2000);
		String naviEntryLocated = "xpath=>//*[text()='" + naviEntryGroup + "']/following-sibling::div[1]/a[text()='" + naviEntry + "']";
		click(naviEntryLocated);
		waitPageLoad(4000);
		System.out.println("Switch Navi");
	}
	
	public void createDoc(String buttonGroup,String button) throws Exception {
		//cbx_mainWin_create-a 
		String buttonGroupLocated = "xpath=>//*[text() = '" + buttonGroup + "']";
		click(buttonGroupLocated);
		//cbx_mainWin_itemSearchNewDoc-a
		String buttonLocated = "xpath=>//*[text() = '" + button + "']";
		click(buttonLocated);
		logger.info("create a doc successfully");
		waitPageLoad(7000);
		
	}
	
	public void saveDoc(String located) throws Exception{
		click(located);
		waitPageLoad(6000);
	}
	
	public void selectionClick(String located) throws Exception {
		click(located);
	}
	
	public void productCategorySelectAll(String located) throws Exception{
		selectionClick(located);
		WebElement element = findElement(BaseElementLocateRule.XPATH+ ".//*[@id='cbx_mainWin_productCategoryViewGrid_SEL_COL-cave']/div[2]/span/label");
		element.click();
		WebElement okElement = findElement(BaseElementLocateRule.XPATH+ ".//*[text()='OK']");
		okElement.click();
	}
	
	public void popupWithNoValueSearch(String located) throws Exception{
//		//*[@id='cbx_mainWin_refItemViewToolBar']/div/i/input
		WebElement searchElement = findElement(located);
		searchElement.sendKeys(Keys.ENTER);
		
	}
	public void selectionValue(String valueLocated) throws Exception {
//		
		click(valueLocated);
	}
	
	public void setSelection(String  selectionLocated, String searchBarlocated, String firstRowLocated) throws Exception, InterruptedException {
		selectionClick(selectionLocated);
		waitPageLoad(4000);
		popupWithNoValueSearch(searchBarlocated);
		waitPageLoad(5000);
		selectionValue(firstRowLocated);
		waitPageLoad(4000);
	}
	public void popUpSingle(String  buttonLocated, String searchBarlocated, String firstRowLocated) throws InterruptedException, Exception {
		setSelection(buttonLocated, searchBarlocated, firstRowLocated);
	}
	
	public void popupMutipleWithFirstData(String  buttonLocated, String searchBarlocated,String firstCheckLocated) throws Exception {
		selectionMultipleFirstRowCheck(buttonLocated, searchBarlocated, firstCheckLocated);
	}
	public void selectionMultipleFirstRowCheck(String  selectionLocated, String searchBarlocated,String firstCheckLocated) throws Exception {
		setSelection(selectionLocated, searchBarlocated, firstCheckLocated);
		WebElement okElement = findElement(BaseElementLocateRule.XPATH+ ".//*[text()='OK']");
		okElement.click();
		waitPageLoad(3000);
	}
	
	public void setDropDownValue(String btnlocated, String valueLocated) throws Exception {
		WebElement element = findElement(btnlocated);
		element.click();
		WebElement valueElement = findElement(valueLocated);
		valueElement.click();
	}
	
	public void upload(String btnlocated,String value) throws Exception {
		WebElement element = findElement(btnlocated);
		element.sendKeys(value);
	}
	
	public void setCheckBox(String located) throws Exception {
		click(located);
	}
	
	public void setDataBoxWithTodayButton(String fieldBtnLocated, String todayButton) throws Exception {
		click(fieldBtnLocated);
		waitPageLoad(3000);
		click(todayButton);
	}
	
	public void setDataBoxWithValue(String fieldValueLocated, String value) throws Exception {
//		WebElement element = findElement(fieldValueLocated);
//		element.sendKeys(value);
		setValue(fieldValueLocated, value);
	}
	
	public void setIntValue(String located, int value) throws Exception {
		setValue(located, String.valueOf(value));
	}
	
	public void setDecimalValue(String located, double value) throws Exception {
		setValue(located, String.valueOf(value));
	}
	
	public void fillFieldsInAllSections(String type, String located, String value, String searchBarLocated, String firstRowLocated) throws Exception {
		if ("text".equalsIgnoreCase(type)) {
			setValue(located, value);
		} else if ("textarea".equalsIgnoreCase(type)) {
			setValue(located, value);
		} else if ("number".equalsIgnoreCase(type)) {
			setIntValue(located, Integer.valueOf(value));
		} else if ("decimal".equalsIgnoreCase(type)) {
			setDecimalValue(located, Double.valueOf(value));
		} else if ("date".equalsIgnoreCase(type)) {
			setDataBoxWithValue(located, value);
		} else if ("dropdown".equalsIgnoreCase(type)) {
			setDropDownValue(located, value);
		} else if ("selectionSingle".equalsIgnoreCase(type)) {
			setSelection(located, searchBarLocated, firstRowLocated);
		} else if ("selectionMutiple".equalsIgnoreCase(type)) {
			selectionMultipleFirstRowCheck(located, searchBarLocated, firstRowLocated);
		} else if ("checkbox".equalsIgnoreCase(type)) {
			setCheckBox(located);
		} else if ("attachment".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String attachmentPath = path+"//attachments/1.jpg";
			upload(located, attachmentPath);
		} else if ("productCategory".equalsIgnoreCase(type)) {
			productCategorySelectAll(located);
		} else if ("image".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String imagePath = path+"//images/1.jpg";
			upload(located, imagePath);
			
		}
	}
	
	public void fillFieldsInAllSections(String type, String module, String field, String value) throws Exception {
		if ("text".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setValue(located, value);
			waitPageLoad(2000);
		} else if ("textarea".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setValue(located, value);
			waitPageLoad(2000);
		} else if ("number".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setIntValue(located, Integer.valueOf(value));
			waitPageLoad(2000);
		} else if ("decimal".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setDecimalValue(located, Double.valueOf(value));
		} else if ("date".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setDataBoxWithValue(located, value);
			waitPageLoad(2000);
		} else if ("dropdown".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderDropdownXpath(type, module, field);
			setDropDownValue(locateds.get(0), locateds.get(1));
			waitPageLoad(3000);
		} else if ("selectionSingle".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderSelectionXpath(type, module, field);
			setSelection(locateds.get(0), locateds.get(1), locateds.get(2));
		} else if ("selectionMultiple".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderSelectionXpath(type, module, field);
			selectionMultipleFirstRowCheck(locateds.get(0), locateds.get(1), locateds.get(2));
			waitPageLoad(5000);
		} else if ("checkbox".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			setCheckBox(located);
			waitPageLoad(2000);
		} else if ("attachment".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String attachmentPath = path+"//attachments/1.jpg";
			String located = bulidHeaderXpath(type, field);
			upload(located, attachmentPath);
			waitPageLoad(4000);
		} else if ("productCategory".equalsIgnoreCase(type)) {
			String located = buildHeaderIDPath(type, module, field);
			productCategorySelectAll(located);
			waitPageLoad(5000);
		} else if ("image".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String imagePath = path+"//images/1.jpg";
			String located = bulidHeaderXpath(type, field);
			upload(located, imagePath);
			waitPageLoad(4000);
			
		}
	}
	
	
	public void fillFieldsInAllSectionsByFieldLabel(String type, String module, String fieldLabel, String value, String winPopTitle) throws Exception {
		if ("text".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			setValue(located, value);
			waitPageLoad(2000);
		} else if ("textarea".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			setValue(located, value);
			waitPageLoad(2000);
		} else if ("number".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			setIntValue(located, Integer.valueOf(value));
			waitPageLoad(2000);
		} else if ("decimal".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			setDecimalValue(located, Double.valueOf(value));
		} else if ("date".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);;
			setDataBoxWithValue(located, value);
			waitPageLoad(2000);
		} else if ("dropdown".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderDropdownByFieldLabel(type, module, fieldLabel);
			setDropDownValue(locateds.get(0), locateds.get(1));
			waitPageLoad(3000);
		} else if ("selectionSingle".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderSelectionByFieldLabel(type, winPopTitle, fieldLabel);
			setSelection(locateds.get(0), locateds.get(1), locateds.get(2));
		} else if ("selectionMultiple".equalsIgnoreCase(type)) {
			List<String> locateds = buildHeaderSelectionByFieldLabel(type, winPopTitle, fieldLabel);
			selectionMultipleFirstRowCheck(locateds.get(0), locateds.get(1), locateds.get(2));
			waitPageLoad(5000);
		} else if ("checkbox".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			setCheckBox(located);
			waitPageLoad(2000);
		} else if ("attachment".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String attachmentPath = path+"//attachments/1.jpg";
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			upload(located, attachmentPath);
			waitPageLoad(4000);
		} else if ("productCategory".equalsIgnoreCase(type)) {
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);
			productCategorySelectAll(located);
			waitPageLoad(5000);
		} else if ("image".equalsIgnoreCase(type)) {
			String path = System.getProperty("user.dir");
			String imagePath = path+"//images/1.jpg";
			String located = buildHeaderFieldPathByFieldLabel(type, module, fieldLabel);;
			upload(located, imagePath);
			waitPageLoad(4000);
			
		}
	}
	
	public String  buildHeaderIDPath(String fieldType,String module, String field) {
		String locatePath = "id=>";
		StringBuffer sbBuffer = new StringBuffer(locatePath);
		String path = StringUtils.EMPTY;
		if ("text".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field;
		} else if ("textarea".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field+"-real";
		} else if ("number".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field;
		} else if ("decimal".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field;
		} else if ("date".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field+"-real";
		} else if ("checkbox".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field+"-cnt";
		} else if ("productCategory".equals(fieldType)) {
			path = "cbx_" + module + "Form_"+field+"-btn";
		}
		logger.info("build header field " + field + " Path is " + path);
		sbBuffer.append(path);
		return sbBuffer.toString();
		
		
	}
	
	
	public String  buildHeaderFieldPathByFieldLabel(String fieldType,String module, String fieldLabel) {
		String locatePath = "xpath=>";
		StringBuffer sbBuffer = new StringBuffer(locatePath);
		String path = StringUtils.EMPTY;
		if ("text".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div/input";
		} else if ("textarea".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//textarea";
		} else if ("number".equals(fieldType)) {
			path =  "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//input";
		} else if ("decimal".equals(fieldType)) {
			path =  "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//input";
		} else if ("date".equals(fieldType)) {
			path =  "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//input";
		} else if ("checkbox".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//label";
		} else if ("productCategory".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//i";
		} else if ("image".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../following-sibling::div//form/input";
		} else if ("attachment".equals(fieldType)) {
			path = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//form/input";
		}
		logger.info("build header field " + fieldLabel + " Path is " + path);
		sbBuffer.append(path);
		return sbBuffer.toString();
		
		
	}
	public String bulidHeaderXpath(String fieldType, String field) {
		String locatePath = "xpath=>";
		StringBuffer sbBuffer = new StringBuffer(locatePath);
		String path = StringUtils.EMPTY;
		if ("attachment".equalsIgnoreCase(fieldType)){
			path = "//*[contains(@id, '" + field +"') ]//form/input";
		} else if ("image".equals(fieldType)) {
			path = "//*[contains(@id, '" + field +"_ROW') ]//form/input";
		}
		logger.info("build header field " + field + " Path is " + path);
		sbBuffer.append(path);
		return sbBuffer.toString();
	}
	
	public List<String> buildHeaderSelectionXpath(String fieldType, String module, String field) {
		List<String> paths= new ArrayList<>();
		if (fieldType.contains("selection")) {
			String locatePath = "xpath=>";
			String btnPath = "cbx_" + module + "Form_"+field+"-btn";
			logger.info("build header selection btn Path is " + btnPath);
			paths.add("id=>" + btnPath);
			String searchBarPath = "//*[contains(@id, '" + field + "ViewToolBar')]//input";
			logger.info("build header selection search bar Path is " + searchBarPath);
			paths.add(locatePath + searchBarPath);
			String firstDataPath = StringUtils.EMPTY;
			if (fieldType.contains("Single")) {
				firstDataPath = "//*[contains(@id, '"+ field +"ViewGrid-cave')]/tbody[1]/tr[1]";
			}
			if (fieldType.contains("Multiple")) {
				firstDataPath = "//*[contains(@id, '"+ field +"ViewGrid-cave')]/tbody[1]/tr[1]/td[2]/span/label";
			}
			logger.info("build header selection first record Path is " + firstDataPath);
			paths.add(locatePath + firstDataPath);
			
		}
		
		return paths;
		
	}
	
	public List<String> buildHeaderSelectionByFieldLabel(String fieldType, String winPopTitle, String fieldLabel) {
		List<String> paths= new ArrayList<>();
		if (fieldType.contains("selection")) {
			String locatePath = "xpath=>";
			String btnPath = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div//i";
			logger.info("build header selection btn Path is " + btnPath);
			paths.add(locatePath + btnPath);
			String searchBarPath =  "//*[text()='" + winPopTitle + "']/following-sibling::div//i/input";
			logger.info("build header selection search bar Path is " + searchBarPath);
			paths.add(locatePath + searchBarPath);
			String firstDataPath = StringUtils.EMPTY;
			if (fieldType.contains("Single")) {
				firstDataPath = "//*[text()='" + winPopTitle + "']/following-sibling::div//table[contains(@id,'ViewGrid-cave')]/tbody[1]/tr[1]";
			}
			if (fieldType.contains("Multiple")) {
				firstDataPath = "//*[text()='" + winPopTitle + "']/following-sibling::div//table[contains(@id,'ViewGrid-cave')]/tbody[1]/tr[1]/td[2]/span/label";
			}
			logger.info("build header selection first record Path is " + firstDataPath);
			paths.add(locatePath + firstDataPath);
			
		}
		
		return paths;
		
	}
	
	public List<String> buildHeaderDropdownXpath(String fieldType, String module, String field){
		List<String> paths= new ArrayList<>();
		if ("dropdown".equals(fieldType)) {
			String btnPath = "cbx_" + module + "Form_"+field+"-btn";
			logger.info("build header dropdown btn Path is " + btnPath);
			paths.add("id=>" + btnPath);
			String firstDropdownValue = "//*[contains(@id, '" + field +"-cave')]/li[2]/span[2]";
			logger.info("build header dropdown frist value Path is " + firstDropdownValue);
			paths.add("xpath=>" + firstDropdownValue);
		}
		return paths;
	}
	
	public List<String> buildHeaderDropdownByFieldLabel(String fieldType, String module, String fieldLabel){
		List<String> paths= new ArrayList<>();
		if ("dropdown".equals(fieldType)) {
			String btnPath = "//*[text()='" + fieldLabel + ":']/../../following-sibling::div/span/a";
			logger.info("build header dropdown btn Path is " + btnPath);
			paths.add("xpath=>" + btnPath);
			//主要操作，肯定只有一个dropdown 下拉出现， 所有用class能找到，只会找到一个
			String firstDropdownValue = "//*[@class= 'z-combobox-popup  z-combobox-open z-combobox-shadow']/ul/li[2]/span[2]";
			logger.info("build header dropdown frist value Path is " + firstDropdownValue);
			paths.add("xpath=>" + firstDropdownValue);
		}
		return paths;
	}
	
	public String buildGridPathByColumnLabel(String fieldType, String grid, String columnLabel) throws Exception {
		String path = null;
		String fieldId = getGridFieldIdByFieldLabel(grid, columnLabel);
		if (StringUtils.isNotBlank(fieldId)) {
			path = bulidGridXpath(fieldType, fieldId);
		}
		return path;
		
	}
	
	public List<String> buildGridDropDownSelectionPathByColumnLabel(String fieldType, String grid, String columnLabel) throws Exception {
		List<String> paths = null;
		String fieldId = getGridFieldIdByFieldLabel(grid, columnLabel);
		if (StringUtils.isNotBlank(fieldId)) {
			if ("dropdown".equals(fieldType)) {
				paths = buildGridDropdownXath(fieldType, fieldId);
			} else if ("selection".equals(fieldType)) {
				paths = buildGridSelectionXpath(fieldType, fieldId);
			}
		}
		return paths;
		
	}
	
	public String bulidGridXpath(String fieldType, String field) {
		String locatePath = "xpath=>";
		StringBuffer sbBuffer = new StringBuffer(locatePath);
		String path = StringUtils.EMPTY;
		if ("text".equalsIgnoreCase(fieldType)){
			path = "//td[contains(@id, '" + field +"_CELL') ]/input";
		} else if ("textarea".equals(fieldType)) {
			path = "//td[contains(@id, '" + field +"_CELL') ]/div/textarea";
		} else if ("image".equals(fieldType)) {
			path = "//td[contains(@id, '"+ field +"_CELL')]//form/input";
		} else if ("checkbox".equals(fieldType)) {
			path = "//td[contains(@id, '" + field +"_CELL') ]//label";
		} else if ("attachment".equals(fieldType)) {
			path = "//td[contains(@id, '"+ field +"_CELL')]//form/input";
		} else if ("date".equals(fieldType)) {
			path = "//td[contains(@id, '" + field+ "_CELL')]//input";
		} else if ("number".equals(fieldType)) {
			path = "//td[contains(@id, '" + field +"_CELL') ]/input";
		} else if ("decimal".equals(fieldType)) {
			path = "//td[contains(@id, '" + field +"_CELL') ]/input";
		}
		sbBuffer.append(path);
		logger.info("build " + field + " path is " + sbBuffer.toString());
		return sbBuffer.toString();
	} 
	
	public List<String> buildGridDropdownXath(String fieldType, String field) {
		List<String> paths= new ArrayList<>();
		if ("dropdown".equals(fieldType)) {
			String btnPath = "//td[contains(@id, '" + field + "_CELL')]//a";
			logger.info("build grid dropdown btn Path is " + btnPath);
			paths.add("xpath=>" + btnPath);
			String firstDropdownValue = "//div[contains(@id, '"+ field + "-pp')]/ul[contains(@id, '" + field + "-cave')]/li[2]/span[2]";
			logger.info("build grid dropdown frist value Path is " + firstDropdownValue);
			paths.add("xpath=>" + firstDropdownValue);
		}
		return paths;
	}
	
	
	public List<String> buildGridSelectionXpath(String fieldType, String field) {
		List<String> paths= new ArrayList<>();
		if (fieldType.contains("selection")) {
			String locatePath = "xpath=>";
			String btnPath = "//td[contains(@id, '" + field + "_CELL')]//i" ;
			logger.info("build grid selection btn Path is " + btnPath);
			paths.add(locatePath + btnPath);
			String searchBarPath = "//div[contains(@id,'cbx_mainWin_ViewToolBar')]//input";
			logger.info("build grid selection search bar Path is " + searchBarPath);
			paths.add(locatePath + searchBarPath);
			String firstDataPath = "//div[contains(@id,'cbx_mainWin_ViewGrid-body')]//label";
			logger.info("build grid selection first record Path is " + firstDataPath);
			paths.add(locatePath + firstDataPath);
			
		}
		
		return paths;
		
	}
	
	public void fillValueInGrid(String fieldType, String field, String value) throws Exception {
		if ("text".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setValue(located, value);
		} else if ("textarea".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setValue(located, value);
		} else if ("date".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setDataBoxWithValue(located, value);
		} else if ("checkbox".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setCheckBox(located);
		} else if ("image".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			String path = System.getProperty("user.dir");
			String imagePath = path+"//images/1.jpg";
			upload(located, imagePath);
		} else if ("attachment".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			String path = System.getProperty("user.dir");
			String attachmentPath = path+"//attachments/1.jpg";
			upload(located, attachmentPath);
		} else if ("selection".equals(fieldType)) {
			List<String> paths = buildGridSelectionXpath(fieldType, field);
			popupMutipleWithFirstData(paths.get(0), paths.get(1), paths.get(2));
		} else if ("dropdown".equals(fieldType)) {
			List<String> dropdownPaths = buildGridDropdownXath(fieldType, field);
			setDropDownValue(dropdownPaths.get(0), dropdownPaths.get(1));
		} else if ("number".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setIntValue(located, Integer.valueOf(value));
		} else if ("decimal".equals(fieldType)) {
			String located = bulidGridXpath(fieldType, field);
			setDecimalValue(located, Double.valueOf(value));
		}
		
	}
	
	public void clickGridButton(String grid, String gridButton, String winTitle) throws Exception{
		String buttonLocated = "xpath=>//*[text()='" + grid + "']/../following-sibling::div/a[text()='" + gridButton + "']";
		if (winTitle != null) {
			String searchBarlocated = "xpath=>//*[text()='" + winTitle + "']/following-sibling::div//i/input";
			String firstCheckLocated = "xpath=>//*[text()='" + winTitle + "']/following-sibling::div//table[contains(@id,'ViewGridGrid-cave')]/tbody[1]/tr[1]/td[2]/span/label";
			popupMutipleWithFirstData(buttonLocated, searchBarlocated, firstCheckLocated);
		} else {
			click(buttonLocated);
		}
		waitPageLoad(3000);
	}
	
	public void fillValueInGridByColumnLabel(String fieldType, String grid, String columnLabel, String value) throws Exception {
		if ("text".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setValue(located, value);
		} else if ("textarea".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setValue(located, value);
		} else if ("date".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setDataBoxWithValue(located, value);
		} else if ("checkbox".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setCheckBox(located);
		} else if ("image".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			String path = System.getProperty("user.dir");
			String imagePath = path+"//images/1.jpg";
			upload(located, imagePath);
			waitPageLoad(3000);
		} else if ("attachment".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			String path = System.getProperty("user.dir");
			String attachmentPath = path+"//attachments/1.jpg";
			upload(located, attachmentPath);
			waitPageLoad(3000);
		} else if ("selection".equals(fieldType)) {
			List<String> paths = buildGridDropDownSelectionPathByColumnLabel(fieldType, grid, columnLabel);
			popupMutipleWithFirstData(paths.get(0), paths.get(1), paths.get(2));
		} else if ("dropdown".equals(fieldType)) {
			List<String> dropdownPaths = buildGridDropDownSelectionPathByColumnLabel(fieldType, grid, columnLabel);
			setDropDownValue(dropdownPaths.get(0), dropdownPaths.get(1));
		} else if ("number".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setIntValue(located, Integer.valueOf(value));
		} else if ("decimal".equals(fieldType)) {
			String located = buildGridPathByColumnLabel(fieldType, grid, columnLabel);
			setDecimalValue(located, Double.valueOf(value));
		}
		waitPageLoad(2000);
	}
	
	public void switchTabLabel(String tab) throws Exception {
		
		click("xpath=>//*[text() = '" + tab + "']");
	}
	
public void switchTabXpath(String located) throws Exception {
		
		click(located);
	}
	
	public void fillFormAllFields(List<FormUI> formUIs) throws Exception {
		String currentTab = StringUtils.EMPTY;
		for (FormUI formUI : formUIs) {
			String tab = formUI.getTabPath();
			Boolean isCommon = formUI.getIsCommon();
			Boolean isGrid = formUI.getIsGrid();
			if (StringUtils.isNotBlank(tab)) {
				if (!currentTab.equals(tab)) {
					currentTab = tab;
					switchTabXpath(currentTab);
					waitPageLoad(5000);
				}
				fillAllValues(formUI, isCommon, isGrid);
			} else {
				fillAllValues(formUI, isCommon, isGrid);
			}
		}
	}
	
	private void fillAllValues(FormUI formUI, Boolean isCommon, Boolean isGrid) throws Exception {
		if (BooleanUtils.isTrue(isCommon) && BooleanUtils.isFalse(isGrid)) {
			fillFieldsInAllSections(formUI.getFieldType(), formUI.getFieldPath(), formUI.getFieldValue(), formUI.getSearchBarLocated(), formUI.getFirstRowLocated());
		}
		if (BooleanUtils.isTrue(isCommon) && BooleanUtils.isTrue(isGrid)) {
			//use grid button, searchBarLocated, and firstRowDataLocated
			popupMutipleWithFirstData(formUI.getGridButtonPath(), formUI.getSearchBarLocated(), formUI.getFirstRowLocated());
			// 创建填充grid 数据的方法
//			fillValueInGrid(fieldType, field, value);
		}
		if (BooleanUtils.isFalse(isCommon) && BooleanUtils.isFalse(isGrid)) {
			if ("New Set".equals(formUI.getButton())) {
				fillFieldsInAllSections(formUI.getFieldType(), formUI.getFieldPath(), formUI.getFieldValue(), formUI.getSearchBarLocated(), formUI.getFirstRowLocated());
			}
		}
		if (BooleanUtils.isFalse(isCommon) && BooleanUtils.isTrue(isGrid)) {
			if ("New Set".equals(formUI.getButton())) {
				popupMutipleWithFirstData(formUI.getGridButtonPath(), formUI.getSearchBarLocated(), formUI.getFirstRowLocated());
				// 创建填充grid 数据的方法
			}
		}
	}
	
	
	public void fillFormAllFieldsValue(String specialButton, List<FormUI1> formUIs) throws Exception {
		String currentTab = StringUtils.EMPTY;
		for (FormUI1 formUI : formUIs) {
			String tab = formUI.getTab();
			Boolean isCommon = formUI.getIsCommon();
			Boolean isGrid = formUI.getIsGrid();
			String gridButton = formUI.getGridButton();
			String grid = formUI.getGrid();
			String winTitle = formUI.getWinTitle();
			if (StringUtils.isNotBlank(tab)) {
				if (!currentTab.equals(tab)) {
					currentTab = tab;
					switchTabLabel(currentTab);
					waitPageLoad(5000);
				}
			}
			if (BooleanUtils.isTrue(isGrid) && StringUtils.isNotBlank(gridButton)) {
				clickGridButton(grid, gridButton, winTitle);
				continue;
			}
			fillAllValuesForForm(specialButton, formUI, isCommon, isGrid);
				
			
		}
	}
	
	
	private void fillAllValuesForForm(String specialButton, FormUI1 formUI, Boolean isCommon, Boolean isGrid) throws Exception {
		String fieldType = formUI.getFieldType();
		String fieldLabel = formUI.getFieldLabel();
		String value = formUI.getValue();
		String winTitle = formUI.getWinTitle();
		String grid = formUI.getGrid();
		if (BooleanUtils.isTrue(isCommon) && BooleanUtils.isFalse(isGrid)) {
			fillFieldsInAllSectionsByFieldLabel(fieldType, formUI.getModule(), fieldLabel, value, winTitle);
		}
		if (BooleanUtils.isTrue(isCommon) && BooleanUtils.isTrue(isGrid)) {
			//use grid button, searchBarLocated, and firstRowDataLocated
//			clickGridButton(grid, gridButton, winTitle);
			// 创建填充grid 数据的方法
			fillValueInGridByColumnLabel(fieldType, grid, fieldLabel, value);
		}
		if (BooleanUtils.isFalse(isCommon) && BooleanUtils.isFalse(isGrid)) {
			
			if (StringUtils.equals(specialButton, formUI.getButton())) {
				fillFieldsInAllSectionsByFieldLabel(fieldType, formUI.getModule(), fieldLabel, value, winTitle);
			}
		}
		if (BooleanUtils.isFalse(isCommon) && BooleanUtils.isTrue(isGrid)) {
			if (StringUtils.equals(specialButton, formUI.getButton())) {
//				clickGridButton(grid, gridButton, winTitle);
				// 创建填充grid 数据的方法
				fillValueInGridByColumnLabel(fieldType, grid, fieldLabel, value);
			}
		}
	}
	
	public boolean isSaveSuccess() throws Exception{
		boolean isSaveSuccess = false;
		WebElement validationEle = null;
		try {
			
			validationEle = findElement(BaseElementLocateRule.ID + "cbx_mainWin_validationErrorDiv-chdex");
		} catch (Exception e) {
			isSaveSuccess = true;
		} finally {
			
			if (validationEle != null && validationEle.isDisplayed()) {
				isSaveSuccess = false;
			} else {
				isSaveSuccess = true;
			}
		}
		return isSaveSuccess;
	}
	
	
	public void collapseRHP() {
		try {
			WebElement findElement = findElement("xpath=>//*[contains(@class, 'z-borderlayout-icon z-east-exp')]");
			if (findElement != null) {
				findElement.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getGridFieldIdByFieldLabel(String grid, String field) throws Exception {
		String located = "xpath=>//*[text()='" + grid + "']/../following-sibling::div[@class='z-grid']//tr[2]//span[text() = '" + field + "']/../../..";
		String fieldId = StringUtils.EMPTY;
		WebElement element = findElement(located);
		if (element != null && element.isEnabled()) {
			String idAttribute = element.getAttribute("id");
			fieldId = StringUtils.substringAfterLast(idAttribute, "_");
		}
		
		return fieldId;
		
	}
	
	
	public void closeWarningMsgPopup(){
		try {
			WebElement warningMsgPopupElement = findElement("xpath=>//*[@class='z-messagebox-window  z-window z-window-highlighted z-window-shadow']");
			if (warningMsgPopupElement != null) {
				WebElement OKElement = findElement("xpath=>//*[text()='OK']");
				OKElement.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
