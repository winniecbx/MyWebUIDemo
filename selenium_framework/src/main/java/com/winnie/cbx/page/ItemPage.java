package com.winnie.cbx.page;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import com.winnie.cbx.common.CommonFunction;
import com.winnie.element.located.BaseElementLocateRule;
import com.winnie.element.located.FormUI1;
import com.winnie.element.located.FormUIButton;
import com.winnie.element.mapper.FormUIMapper;
import com.winnie.util.DataBaseUtil;

public class ItemPage extends CommonFunction {
	private static String PRODUCT_NAVI = BaseElementLocateRule.XPATH+".//*[text()='Products']";
	

	public void exportItemCurrentFields() throws Exception {
		
//		switchNavi(PRODUCT_NAVI);
		Thread.sleep(5000);//wait page load
		exportCurrentFields();
		waitPageLoad(5000);
		
//		Thread.sleep(10000);
		
	}
	
	public void listingCreateItemTypeDoc() throws Exception {
//		LoginPage loginPage = new LoginPage();
//		loginPage.cbxLogin();
		
//		SqlSession sqlSession = DataBaseUtil.getSqlSession();
//		ListUI listUI = sqlSession.getMapper(ListUIMapper.class).getListUiButton("item", "form","New Item");
//		
//		sqlSession.selectOne("getListUiButton", arg1)
		switchNavi("Products", "Items", "Active");
//		switchNavi(listUI.getNaviPath());
		Thread.sleep(5000);//wait page load
//		createDoc("Create", "New Item");
//		createDoc(BaseElementLocateRule.ID +"cbx_mainWin_create-a",BaseElementLocateRule.ID +"cbx_mainWin_itemSearchNewDoc-a");
//		createDoc(BaseElementLocateRule.ID +"cbx_mainWin_create-a", listUI.getUiButtonPath());
//		waitPageLoad(7000);
//		loginPage.cbxLogout();
		
		
	}
	
	public void listingCreateSetTypeDoc() throws Exception {
//		LoginPage loginPage = new LoginPage();
//		loginPage.cbxLogin();
		Thread.sleep(5000);
//		switchNavi(PRODUCT_NAVI);
		Thread.sleep(10000);//wait page load
		createDoc(BaseElementLocateRule.ID +"cbx_mainWin_create-a",BaseElementLocateRule.ID+"cbx_mainWin_itemSearchNewSetDoc-a" );
		waitPageLoad(11000);
//		loginPage.cbxLogout();
		
	}
	
	
	public boolean listingCreateItemTypeDoc2save() throws Exception {
//		listingCreateItemTypeDoc();
//		waitPageLoad(7000);
		collapseRHP();
		waitPageLoad(2000);
		return itemSave();
	}
	
	private boolean itemSave() throws Exception {
		
//		setCheckBox(BaseElementLocateRule.ID + "cbx_itemForm_reOrder-cnt");
		
//		setValue(BaseElementLocateRule.ID+"cbx_itemForm_itemDesc-real", "test");
////		cbx_itemForm_itemBrand-btn
//		////*[@id='cbx_itemForm_itemBrand-cave']/li[2]/span[2]
//		setDropDownValue(BaseElementLocateRule.ID + "cbx_itemForm_itemBrand-btn" , BaseElementLocateRule.XPATH+ "//*[@id='cbx_itemForm_itemBrand-cave']/li[2]/span[2]");
//		selectionClick(BaseElementLocateRule.ID+ "cbx_itemForm_productCategory-btn");
		
		SqlSession sqlSession = DataBaseUtil.getSqlSession();
		List<FormUI1> formUIs = sqlSession.getMapper(FormUIMapper.class).getFormUI1("item");
		fillFormAllFieldsValue("", formUIs);
		/**
		 * use fieldId to find element
		
//		fillFieldsInAllSections("productCategory", BaseElementLocateRule.ID+ "cbx_itemForm_productCategory-btn", null, null, null);
		fillFieldsInAllSections("productCategory", "item", "productCategory", null);
		fillFieldsInAllSections("text", "item", "buyerItemNo", "test");
//		fillFieldsInAllSections("textarea", "item", "itemDesc", "test");
		fillFieldsInAllSections("dropdown", "item", "itemBrand", null);
//		fillFieldsInAllSections("checkbox", "item", "reOrder", null);
//		fillFieldsInAllSections("selectionMultiple", "item", "licenses", null);
		waitPageLoad(5000);
		// click Add in PackingDefinition grid
		click("id=>cbx_itemForm_addItemPackingDefinition");
		fillValueInGrid("image", "defaultImage", null);
		fillValueInGrid("dropdown", "type", null);
		fillValueInGrid("text", "skuNo", "WY190501");
		fillValueInGrid("number", "cartonQuantity", "6");
		fillValueInGrid("textarea", "description", "test test test test");
		 
		 */
		
		/**
		 * use field label to find element
		 
		fillFieldsInAllSectionsByFieldLabel("productCategory", "item", "Product Category", null, null);
		fillFieldsInAllSectionsByFieldLabel("text", "item", "Buyer Item No.", "test", null);
		fillFieldsInAllSectionsByFieldLabel("textarea", "item", "Item Description", "test test", null);
		fillFieldsInAllSectionsByFieldLabel("dropdown", "item", "Brand", null, null);
		fillFieldsInAllSectionsByFieldLabel("checkbox", "item", "Re-order", null, null);
		fillFieldsInAllSectionsByFieldLabel("selectionMultiple", "item", "Licenses", null, "Licenses Lookup");
		fillFieldsInAllSectionsByFieldLabel("selectionSingle", "item", "Reference Item.", null, "Item Lookup");
		
		clickGridButton("Packing Definition", "Add", null);
		fillValueInGridByColumnLabel("image", "Packing Definition", "Image", null);
		fillValueInGridByColumnLabel("dropdown", "Packing Definition", "Type", null);
		fillValueInGridByColumnLabel("text", "Packing Definition", "SKU No.", "WY190501");
		fillValueInGridByColumnLabel("number", "Packing Definition", "Carton Quantity", "6");
		fillValueInGridByColumnLabel("textarea", "Packing Definition", "Description", "test test tessss");
		switchTabLabel("Colors, Sizes & SKUs");
		clickGridButton("Colors/Patterns", "Select Colors...", "Color Lookup");
		fillValueInGridByColumnLabel("checkbox", "Colors/Patterns", "Primary", null);
		*/
		
//		productCategorySelectAll();
//		waitPageLoad();
//		String path = System.getProperty("user.dir");
//		String value = path+"//images/1.jpg";
//		.//*[text()='Select File' and @type='button']
//		.//*[@class='c-default-dropupload z-div']
//		upload(BaseElementLocateRule.XPATH+"//*[@type='file']" , value);
//		setSelection(BaseElementLocateRule.ID + "cbx_itemForm_refItem-btn",BaseElementLocateRule.XPATH+ "//*[@id='cbx_mainWin_refItemViewToolBar']/div/i/input",BaseElementLocateRule.XPATH+"//*[@id='cbx_mainWin_refItemViewGrid-cave']/tbody[1]/tr[1]");
		////*[@id='cbx_mainWin_licensesViewGrid-cave']/tbody[1]/tr[1]/td[2]/span/label
//		selectionMultipleFirstRowCheck(BaseElementLocateRule.ID+"cbx_itemForm_licenses-btn", BaseElementLocateRule.XPATH+"//*[@id='cbx_mainWin_licensesViewToolBar']/div/i/input", BaseElementLocateRule.XPATH+"//*[@id='cbx_mainWin_licensesViewGrid-cave']/tbody[1]/tr[1]/td[2]/span/label");
//		setDataBoxWithTodayButton(BaseElementLocateRule.ID+"cbx_itemForm_originalShipmentDate-btn", BaseElementLocateRule.XPATH+"//*[@id='cbx_itemForm_originalShipmentDate-pp']/button");
//		setIntValue(BaseElementLocateRule.ID+"cbx_itemForm_masterCasePack", 6);
//		setDecimalValue(BaseElementLocateRule.ID+"cbx_itemForm_refPrice", 3.14);
//		waitPageLoad();
//		setColorSizeTab();
		//		saveDoc(BaseElementLocateRule.ID + "cbx_itemForm_saveDoc-a");
		FormUIButton saveButton = sqlSession.getMapper(FormUIMapper.class).getFormButton("item", "Save");
		saveDoc(saveButton.getButtonPath());
		waitPageLoad(3000);
		
		// grid xpath //*[@id='cbx_itemForm_itemColor-cave']/tbody//td[@class='c-cell-checkbox z-cell' and contains(@id, 'isPrimary')]/span/label
		
//		setCheckBox(BaseElementLocateRule.XPATH + "//*[@id='cbx_itemForm_itemColor-cave']/tbody//td[@class='c-cell-checkbox z-cell' and contains(@id, 'isPrimary')]/span/label");
//		return isSaveSuccess();
		return true;
	}

	
	
	private void setColorSizeTab() throws Exception{
		click(BaseElementLocateRule.ID+"cbx_itemForm_tabColorTab-cave");
		waitPageLoad(5000);
		popupMutipleWithFirstData(BaseElementLocateRule.ID+"cbx_itemForm_selectColor", BaseElementLocateRule.XPATH+"//*[@id='cbx_mainWin_popColorLookupViewGridToolBar']/div/i/input", BaseElementLocateRule.XPATH+"//*[@id='cbx_mainWin_popColorLookupViewGridGrid-cave']/tbody[1]/tr[1]/td[2]/span/label");
	}

	

}
