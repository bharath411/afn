package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData_Both {

	File file;
	FileInputStream fis;
	Workbook book;
	Sheet sheet;

	public ExcelData_Both() {
		init("D:/selenium_classes/login.xls");
	}

	public void init(String path) {
		
		file = new File(path);
		try {
			fis = new FileInputStream(file);
			if(path.contains("xlsx")){
				book = new XSSFWorkbook(fis);
			}else
			{
				book = new HSSFWorkbook(fis);
			}
			
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

		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(columnNum);
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
		ExcelData_Both x = new ExcelData_Both();
		System.out.println(x.getTotalNumberOfRows());
		System.out.println(x.getData(11, 1));
	}
}
