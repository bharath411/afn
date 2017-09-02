package sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.Test;

public class ExcelWrite {

	
	
	@Test
	public void init() {
		File file = new File("D:\\new.xls");
		
		
		HSSFWorkbook book = new HSSFWorkbook();	
		HSSFSheet sheet  = book.createSheet("Sheet1");
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("UserName");
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Password");
		
		
		row = sheet.createRow(2);
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Bharath");
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Bharath123");
		
		row = sheet.createRow(3);
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Kumar");
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Kumar123");
		
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			book.write(fos);
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExcelWrite ex = new ExcelWrite();
		ex.init();
	}
}
