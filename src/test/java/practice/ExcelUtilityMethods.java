package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityMethods {

	public String getExcelData(String filePath, String sheetName, int rowNo, int cellNo) {
		DataFormatter df= new DataFormatter();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = df.formatCellValue(cell);
		return data;
	}

	public void setExcelData(String filePath, String sheetName, int rowNo, int cellNo, String value) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		cell.setCellValue(value);

		FileOutputStream fos=null;
		try {
			fos= new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getTestData(String filePath, String expectedTestScriptName, String sheetName) {
		DataFormatter df= new DataFormatter();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map=new HashMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));

			if(testScriptName.equalsIgnoreCase(expectedTestScriptName)) {
				short cellCount = sheet.getRow(i).getLastCellNum();
				for (int j = 1; j < cellCount; j++) {    
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
				}
				break;
			}
		}
		return map;
	}

	public Map<String, List<String>> getMultipleTestData(String filePath,String expectedTestScriptName, String sheetName) {
		DataFormatter df= new DataFormatter();
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, List<String>> map= new HashMap<>();
		for (int i = 1; i <=rowCount; i++) {
			String actTestScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(expectedTestScriptName)) {
				int cellCount=sheet.getRow(i).getLastCellNum();
				for (int j = 1; j < cellCount ; j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					List<String> list= new ArrayList<>();

					for (int k = 2; ; k++) {    
						String data = df.formatCellValue(sheet.getRow(k).getCell(j));
						if(data.equals("")) {
							break;
						}
						else {
							list.add(data);
						}
					}
					map.put(key, list);
				}

			}
		}
		return map;

	}
}