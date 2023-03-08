package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//1--> without using data formatter
		//		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);
		//		Sheet sheet = wb.getSheet("");
		//		Row row = sheet.getRow(0);
		//		Cell cell = row.getCell(0);
		//		String data = cell.toString();
		//		System.out.println(data);
		//		wb.close();
		//		fis.close();

		//		2--> using Data formatter
		//		DataFormatter df= new DataFormatter();
		//		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);
		//		Sheet sheet = wb.getSheet("User");
		//		Row row = sheet.getRow(2);
		//		Cell cell = row.getCell(1);
		//		String data = df.formatCellValue(cell);
		//		System.out.println(data);
		//		wb.close();


//		//3--> using Data formatter
//		DataFormatter df= new DataFormatter();
//		FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("User");
//		int rowCount = sheet.getLastRowNum(); //index
//		int cellCount = sheet.getRow(1).getLastCellNum(); //count
//		for (int i = 1; i < rowCount; i++) {
//			for (int j = 0; j < cellCount; j++) {
//				System.out.println(df.formatCellValue(sheet.getRow(i).getCell(1)));
//			}
//		}
		
		
		//4-->
				String expTestScriptName = "UserRegistrationLoginAndBookAppointmentTest";
				String expKey = "Name";		
		
				DataFormatter df= new DataFormatter();
				FileInputStream fis= new FileInputStream("./src/test/resources/testData.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sheet = wb.getSheet("User");
				int rowCount = sheet.getLastRowNum();//index 4
				String value = "";// declaring value as gobal
				for (int i = 1; i <= rowCount; i++) {
					String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
					System.out.println(testScriptName);
					if(testScriptName.equalsIgnoreCase(expTestScriptName)) {
						short cellCount = sheet.getRow(i).getLastCellNum();
						for (int j = 0; j < cellCount; j++) {    
							String key= df.formatCellValue(sheet.getRow(i).getCell(j));

							if(key.equalsIgnoreCase(expKey)) {
							value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
							break;
							}
						}
						break;
					}
				}
				System.out.println(value);
	}
}
