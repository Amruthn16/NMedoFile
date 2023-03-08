package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1--> convert the physical file into java readable object
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData/commonData.properties");
		//Step 2--> create object for properties class
		Properties p=new Properties();
		//Step 3--> load all keys
		p.load(fis);
		//Step 4--> fetch data
		String password = p.getProperty("userPassword");
		System.out.println(password);
		//step 5--> close input stream
		fis.close();
		p.clear();
	}
}
