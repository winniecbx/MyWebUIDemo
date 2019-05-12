package com.winnie.excel.parse;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParse {
	private static final String LINE_BREAK = "\n"; 
	
	public static void main(String[] args) {
		
//		String idAttribute = "cbx_itemForm_itemPackingDefinition_type";
//		String fieldId = StringUtils.substringAfterLast(idAttribute, "_");
//		System.out.println(fieldId);
		parseExcel();
		
		
	}

	private static void parseExcel() {
		FileInputStream is;
		
		XSSFWorkbook workbook = null;
		try {
			is = new FileInputStream(new File("G:\\cbxUIDemo\\form.xlsx"));
			workbook = new XSSFWorkbook(is);
			
			XSSFSheet createTableSheet = workbook.getSheet("createTable");
			String sheetName = createTableSheet.getSheetName();
			XSSFRow firstRow = createTableSheet.getRow(0);
			short columnCount = firstRow.getLastCellNum();
			System.out.println("column count: " + columnCount);
			StringBuffer sbsql = new StringBuffer().append("drop table if exists field_definition;").append(LINE_BREAK).append("create table if not exists field_definition ").append("(id serial primary key, ");
			StringBuffer columns = new StringBuffer("( ");
//			String createTableSql = 
			for(int i= 0; i<columnCount; i++) {
				XSSFCell cell = firstRow.getCell(i);
				String value = cell.getStringCellValue();
				System.out.println(cell);
				String dbColumnType = " varchar";
				if (value.contains("is")) {
					dbColumnType = " boolean";
				}
				
				if (i== columnCount -1) {
					sbsql.append(" "+ value + dbColumnType + " ); ");
					columns.append(value + ") ");
				} else {
					sbsql.append(" "+ value + dbColumnType + ",  ");
					columns.append(value + ", ");
				}
				
			}
			sbsql.append(LINE_BREAK);
			System.out.println("create table sql is \n " + sbsql.toString());
			String path = System.getProperty("user.dir") + "\\sql\\";
			FileUtils.writeStringToFile(new File(path+ sheetName+".sql"), sbsql.toString(), "UTF-8", false);
			
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int num = 4; num < numberOfSheets; num++) {
				XSSFSheet sheet = workbook.getSheetAt(num);
				StringBuffer insertSql = new StringBuffer();
				createInsertSql(sheet, columnCount, insertSql, columns);
				FileUtils.writeStringToFile(new File(path+ sheet.getSheetName()+".sql"), insertSql.toString(), "UTF-8", false);
			}
			
			
//			System.out.println( sbsql.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void createInsertSql(XSSFSheet sheet, short columnCount, StringBuffer sbsql, StringBuffer columns) {
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("total row is " + lastRowNum);
		for(int i= 1; i<=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			sbsql.append("insert into field_definition ").append(columns.toString()).append("VALUES ( ");
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				Object value = null;
				if (cell != null) {
					value = getCellStringValue(cell);
				}
				if (j== columnCount -1) {
					if (value == null || value instanceof Boolean  ) {
						sbsql.append(value + "); ");	
					} else{
						sbsql.append("'"+ value + "'); ");
					}
				} else {
					if (value == null || value instanceof Boolean) {
						sbsql.append(value+", ");
					} else {
						sbsql.append("'"+ value + "', ");
					}
				}
			}
			sbsql.append(LINE_BREAK);
		}
	}
	
	public static Object getCellStringValue(XSSFCell cell) {
		Object cellValue = null; 
		switch (cell.getCellType()) { 
			case XSSFCell.CELL_TYPE_STRING://字符串类型 
				cellValue = cell.getStringCellValue(); 
				if(((String)cellValue).trim().equals("")||((String)cellValue).trim().length()<=0) 
				cellValue=" "; 
				break; 
			case XSSFCell.CELL_TYPE_NUMERIC: //数值类型 
				cellValue = String.valueOf(cell.getNumericCellValue()); 
				break; 
			case XSSFCell.CELL_TYPE_FORMULA: //公式 
				cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC); 
				cellValue = String.valueOf(cell.getNumericCellValue()); 
				break; 
			case XSSFCell.CELL_TYPE_BLANK: 
//				cellValue=" "; 
				break; 
			case XSSFCell.CELL_TYPE_BOOLEAN: 
				cellValue = cell.getBooleanCellValue(); 
				break; 
			case XSSFCell.CELL_TYPE_ERROR: 
				break; 
			default: 
				break; 
			} 
			return cellValue; 
		 }

}
