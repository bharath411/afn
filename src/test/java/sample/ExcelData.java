package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelData {

	File file;
	FileInputStream fis;
	HSSFWorkbook book;
	HSSFSheet sheet;

	public ExcelData() {
		init();
	}

	public void init() {
		file = new File("D:/selenium_classes/login.xls");
		try {
			fis = new FileInputStream(file);
			book = new HSSFWorkbook(fis);
			sheet = book.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getTotalNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public String getData(int row, int column) {

		HSSFRow row1 = sheet.getRow(row);
		HSSFCell cell1 = row1.getCell(column);
		String value = "";
		switch (cell1.getCellTypeEnum()) {
		case STRING:
			value = cell1.getStringCellValue();
			break;
		case NUMERIC:
			value = String.valueOf((int) cell1.getNumericCellValue());
			break;
		case BLANK:
			value= "";
			break;
		default:
			break;
		}
		;

		return value;
	}

	public static void main(String[] args) {
		ExcelData data1 = new ExcelData();

		System.out.println(data1.getData(3, 1));
	}
	
	
	
	
}
