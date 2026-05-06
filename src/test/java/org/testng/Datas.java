package org.testng;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.utilities.ExcelUtil;

public class Datas {

	String fliepath = "C:\\Users\\Irwin\\automation\\AutoTestNG\\src\\test\\resources\\Excel.xlsx";
	String sheetName = "sheet1";

	@DataProvider(name = "SampleData")
	public Object[][] data() throws IOException {
		return new Object[][] {
				{ ExcelUtil.readExcel(fliepath, 0, 0, sheetName), ExcelUtil.readExcel(fliepath, 0, 1, sheetName) },
				{ ExcelUtil.readExcel(fliepath, 1, 0, sheetName), ExcelUtil.readExcel(fliepath, 1, 1, sheetName) },
				{ ExcelUtil.readExcel(fliepath, 2, 0, sheetName), ExcelUtil.readExcel(fliepath, 2, 1, sheetName) } };
	}

}
