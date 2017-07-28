package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelXRead {
	XSSFSheet sheet = null;

	public ExcelXRead() {
		init();
	}
	
	public void init() {
		File file = new File("D:\\new.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook wookbook = new XSSFWorkbook(fis);

			sheet = wookbook.getSheet("Sheet1");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public int getTotalNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static void main(String[] args) {

		ExcelXRead excel = new ExcelXRead();

		System.out.println(excel.getData(1, 2));
		System.out.println(excel.getData(2, 2));

		int total = excel.getTotalNumberOfRows();
		System.out.println(total);
		for (int i = 1; i <= total; i++) {
			String username = excel.getData(i, 1);
			System.out.print(username);

			String password = excel.getData(i, 2);
			System.out.println(":" + password);
		}

	}
}
