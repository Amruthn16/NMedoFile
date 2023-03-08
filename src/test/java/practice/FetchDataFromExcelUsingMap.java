package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class FetchDataFromExcelUsingMap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
//		String expTestScriptName = "UserRegistrationLoginAndBookAppointmentTest";
//
//		DataFormatter df= new DataFormatter();
//		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("User");
//		int rowCount = sheet.getLastRowNum();
//		Map<String, String> map=new HashMap<>();
//		for (int i = 1; i <= rowCount; i++) {
//			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
//			
//			if(testScriptName.equalsIgnoreCase(expTestScriptName)) {
//				short cellCount = sheet.getRow(i).getLastCellNum();
//				for (int j = 1; j < cellCount; j++) {    
//					String key= df.formatCellValue(sheet.getRow(i).getCell(j));
//					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
//					map.put(key, value);
//					}
//					break;
//
//				}
//			}
//		System.out.println(map.get("Name")+" ==> "+map.get("Password"));

		
		
		
		//--> using map and list for fetching multiple data 
		String expTestScriptName = "UserRegistrationLoginAndBookAppointmentTest";
		DataFormatter df= new DataFormatter();
		FileInputStream fis= new FileInputStream("./src/main/resources/TestData/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("User");
		int rowCount = sheet.getLastRowNum();
		Map<String, List<String>> map= new HashMap<>();
		for (int i = 1; i <=rowCount; i++) {
			String actTestScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actTestScriptName.equalsIgnoreCase(expTestScriptName)) {
				int cellCount=sheet.getRow(i).getLastCellNum();
				for (int j = 1; j < cellCount ; j++) {
					 String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					//String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
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
		 System.out.println(map);

	}
}

