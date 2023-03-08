package practice.TestNg;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestNg {

	
	public class BeforeTestNG 
	{
		@AfterMethod
		public void methodTearDown()
		{
			System.out.println("AfterMethod2");
		}
		@AfterClass
		public void classTearDown()
		{
			System.out.println("AfterClass2");
		}
		@AfterTest
		public void testTearDown()
		{
			System.out.println("AfterTest2");
		}
		@AfterSuite
		public void suiteTearDown()
		{
			System.out.println("AfterSuite2");
		}
		@BeforeSuite
		public void suiteSetup()
		{
			System.out.println("Before Suite2");
		}
		@BeforeTest
		public void testSetup()
		{
			System.out.println("BeforeTest2");
		}
		@Test
		public void test1()
		{
			System.out.println("Test in BeforeNG2.1");
		}
		
		@BeforeClass
		public void classSetup()
		{
			System.out.println("BeforeClass2");
		}
		@BeforeMethod
		public void methodSetup()
		{
			System.out.println("BeforeMethod2");
		}
		@Test
		public void test2()
		{
			System.out.println("Test in BeforeNG2.2");
		}
		@Test
		public void test3()
		{
			System.out.println("Test in BeforeNG2.3");
		}
		
	}

}
