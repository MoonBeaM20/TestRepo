package com.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	public ExcelReader(String path, String sheet) {
		try {
			workbook = new XSSFWorkbook(path);
			this.sheet = workbook.getSheet(sheet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheet) {
		int index = workbook.getSheetIndex(sheet);
		if (index == -1)
			return 0;
		else {
			this.sheet = workbook.getSheetAt(index);
			int number = this.sheet.getPhysicalNumberOfRows();
			return number;
		}
	}
	
	public int getColCount(String sheet) {
		int index = workbook.getSheetIndex(sheet);
		if (index == -1)
			return 0;
		else {
			this.sheet = workbook.getSheetAt(index);
			int number = this.sheet.getRow(0).getLastCellNum();
			return number;
		}
	}
	
	public String getCellData(int row, int col) {
		int index = workbook.getSheetIndex(sheet);
		if (index == -1)
			return "";
		else {
			String cellData= this.sheet.getRow(row).getCell(col).getStringCellValue();
			return cellData;
		}
	}
	
	public Object[][] getTestData(String sheet){
		int row = getRowCount(sheet);
		int col = getColCount(sheet);
		
		Object[][] data = new Object[row][col];
		for(int i=1; i<=row; i++) {
			for (int j=0; j<col; j++) {
				data[i-1][j] = getCellData(i, j);
			}
		}
		return data;
	}
}
