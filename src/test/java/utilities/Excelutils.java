package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class describes Excel related common functionalities
 * 
 * @author Cuckoo George , Feb2,2024
 */
public class Excelutils {

	public static String getCellValue(String xlName, String sheetName, int row, int cellColumn) {
		try {
			File src = new File(xlName);
			FileInputStream fis = new FileInputStream(xlName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFCell cell = sh.getRow(row).getCell(cellColumn);
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else {
				return cell.getRawValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int getRowCount(String xlName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(xlName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);

			int rowCount = sh.getLastRowNum();
			return rowCount;
		} catch (Exception e) {
			return 0;
		}
	}

	public static void putCellValue(String xlName, String sheetName, int row, int cellColumn, String value) {
		try {
			// File src = new File(xlName);
			String path = xlName;
			FileInputStream fis = new FileInputStream(path);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// XSSFSheet sh = wb.getSheet(sheetName);
			XSSFSheet sh = wb.getSheet(sheetName);// XSSFCell cell = sh.getRow(row).getCell(cellColumn);
			XSSFRow row1 = sh.getRow(row);
			if (row1 == null) {
				row1 = sh.createRow(row);
			}
			XSSFCell cell = row1.createCell(cellColumn);
			cell.setCellValue(value);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
