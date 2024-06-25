package com.ust.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String[][] data;
	public static int rowCount;
	public static int cellCount;

	public static String[][] getExcelData(File f, String s) {
		try {
			// Creating workbook object
			Workbook wb = new XSSFWorkbook(f);

			// Creating sheet object
			Sheet sheet = wb.getSheet(s);

			// Storing the number of rows in the sheet
			rowCount = sheet.getLastRowNum() + 1;
			cellCount = sheet.getRow(0).getLastCellNum();

			// Creating 2D array for storing data
			data = new String[rowCount][cellCount];

			// Object for data formatter
			DataFormatter df = new DataFormatter();

			// Read data from the excel sheet
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < cellCount; j++) {
					data[i][j] = df.formatCellValue(row.getCell(j));
				}
			}
			wb.close();
		} catch (IOException e) {
			// Handle IOException related to file I/O operations
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error: " + e.getMessage());
			e.printStackTrace();
		}
		return data;
	}
}
