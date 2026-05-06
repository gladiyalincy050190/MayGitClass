package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtil {

	public static void readExcel(String filePath) throws IOException {
		File fileObj = new File(filePath);
		FileInputStream fiObj = new FileInputStream(fileObj);
		Workbook wbObj = new XSSFWorkbook(fiObj);
		for (int i = 0; i < wbObj.getNumberOfSheets(); i++) {
			Sheet sheet = wbObj.getSheet(wbObj.getSheetName(i));
			System.out.println("Reading SheetName: " + wbObj.getSheetName(i));
			for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
				if (null == sheet.getRow(j)) {
					break;
				}
//				System.out.println("Reading Row: " + sheet.getRow(j));
				Row row = sheet.getRow(j);
				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
					if (null == row.getCell(k)) {
						break;
					}
//					System.out.println("Reading Cell: " + row.getCell(k));
					Cell cell = row.getCell(k);
					getCellTypeByValue(cell.getCellType(), cell);
				}
			}
		}
	}

	public static String readExcel(String filePath, int rowNo, int cellNo, String sheetName) throws IOException {
		File fileObj = new File(filePath);
		FileInputStream fiObj = new FileInputStream(fileObj);
		Workbook wbObj = new XSSFWorkbook(fiObj);
		Sheet sheet = wbObj.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		return cell.getStringCellValue();
	}

	public static void getCellTypeByValue(CellType celltype, Cell cell) {
		if (celltype == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.println("This is a Date: " + cell.getDateCellValue());
			} else {
				System.out.println("This is a Number: " + cell.getNumericCellValue());
			}
		}
		if (celltype == CellType.STRING) {
			System.out.println("This is a String: " + cell.getStringCellValue());
		}
	}

	public static void main(String[] args) throws IOException {
		readExcel("C:\\\\Users\\\\Irwin\\\\maven3.9\\\\test\\\\src\\\\test\\\\resource\\\\testdata\\\\Excel.xlsx");
	}

}
