package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1--> convert the physical file into java readable package
		FileOutputStream fos= new FileOutputStream("./src/test/resources/commonData/commonData.properties");
		//Step 2--> create object of property file
		Properties p= new Properties();
		//Step 3--> store data
		p.setProperty("timeUnit", "15");
		//Step 4--> save data
		p.store(fos, "");
		//Step 5--> close stream
		fos.close();	
	}	
}
