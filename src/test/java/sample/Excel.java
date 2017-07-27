package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class Excel {
	HSSFSheet sheet = null;

	public Excel() {
		init();
	}

	public void init() {
		File file = new File("D:\\selenium_classes\\login.xls");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			HSSFWorkbook wookbook = new HSSFWorkbook(fis);

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

		HSSFRow row = sheet.getRow(rowNum);
		HSSFCell cell = row.getCell(columnNum);
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

		Excel excel = new Excel();

		System.out.println(excel.getData(4, 2));
		System.out.println(excel.getData(3, 2));

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
