package sinppets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {

	public FileInputStream inputStream = null;
	public FileOutputStream outputStream = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String ExcelFilePath;

//	Parameterized constructor
	public ExcelAPI(String ExcelFilePath) throws Exception {
		this.ExcelFilePath = ExcelFilePath;
		inputStream = new FileInputStream(ExcelFilePath);
		workbook = new XSSFWorkbook(inputStream);
		inputStream.close();
	}

	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public void writeData(String sheetName, int rowIndex, String cellValue) throws IOException {

		sheet = workbook.getSheet(sheetName);
//		create row
		row = sheet.createRow(rowIndex);
//		create a cell object to enter value in it using cell index
		row.createCell(0).setCellValue(cellValue);
//		write the data in excel using output stream
		outputStream = new FileOutputStream(ExcelFilePath);
		workbook.write(outputStream);
		workbook.close();
	}

}
