package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData_XLSX {


	File file;
	FileInputStream fis;
	XSSFWorkbook book;
	XSSFSheet sheet;

	public ExcelData_XLSX() {
		init();
	}

	public void init() {
		file = new File("D:/selenium_classes/login.xlsx");
		try {
			fis = new FileInputStream(file);
			book = new XSSFWorkbook(fis);
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

	public String getData(int rowNum, int columnNum) {

		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(columnNum);
		String value = "";
		switch (cell.getCellTypeEnum()) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			int db = (int) cell.getNumericCellValue();
			value = String.valueOf(db);
			break;
		case BOOLEAN:
			boolean b = cell.getBooleanCellValue();
			value = String.valueOf(b);
			break;
		case BLANK:

			break;
		case FORMULA:
			// TO-DO
			break;

		default:
			value = "";
			break;
		}

		return value;
	}
	
	public static void main(String[] args) {
		ExcelData_XLSX x = new ExcelData_XLSX();
		System.out.println(x.getTotalNumberOfRows());
		System.out.println(x.getData(11, 1));
	}
}
