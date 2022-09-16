package sinppets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write {

	public void writeExcel() throws InterruptedException, IOException{
		
		File file = new File(System.getProperty("user.dir")+ "//testData//writedata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("sheet1");
		
//		get last row no.
		int rowNum = sheet.getLastRowNum();
		XSSFRow row = sheet.createRow(rowNum+1);
		
		row.createCell(0).setCellValue("");
		row.createCell(1).setCellValue("");
		
//		write the data in excel using output stream
		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
		wb.close();
		
		
	}
	
	public static void writeExcel(String currentCase, String status, String trStatus, String chainEmail, String type) throws InterruptedException, IOException {

		File file = new File(System.getProperty("user.dir") + "//testData//writedata.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("sheet1");

//		get last row no.
		int rowNum = sheet.getLastRowNum();
		XSSFRow row = sheet.createRow(rowNum + 1);

		row.createCell(0).setCellValue(currentCase);
		row.createCell(1).setCellValue(status);
		row.createCell(2).setCellValue(trStatus);
		row.createCell(3).setCellValue(chainEmail);
		row.createCell(4).setCellValue(type);

//		write the data in excel using output stream
		FileOutputStream outputStream = new FileOutputStream(file);
		wb.write(outputStream);
		wb.close();

	}
}
