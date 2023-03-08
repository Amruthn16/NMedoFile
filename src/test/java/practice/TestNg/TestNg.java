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

public class TestNg {


	public class TestNG 
	{
		@AfterMethod
		public void methodTearDown()
		{
			System.out.println("AfterMethod3");
		}
		@AfterClass
		public void classTearDown()
		{
			System.out.println("AfterClass3");
		}
		@AfterTest
		public void testTearDown()
		{
			System.out.println("AfterTest3");
		}
		@AfterSuite
		public void suiteTearDown()
		{
			System.out.println("AfterSuite3");
		}
		@BeforeSuite
		public void suiteSetup()
		{
			System.out.println("Before Suite3");
		}
		@BeforeTest
		public void testSetup()
		{
			System.out.println("BeforeTest3");
		}
		@Test
		public void test1()
		{
			System.out.println("Test in BeforeNG3.1");
		}

		@BeforeClass
		public void classSetup()
		{
			System.out.println("BeforeClass3");
		}
		@BeforeMethod
		public void methodSetup()
		{
			System.out.println("BeforeMethod3");
		}
		@Test
		public void test2()
		{
			System.out.println("Test in BeforeNG3.2");
		}
		@Test
		public void test3()
		{
			System.out.println("Test in BeforeNG3.3");
		}
	}

}
