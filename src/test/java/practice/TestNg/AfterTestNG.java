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



//@Listeners(com.hms.nml.genericUtilities.retry.SetTestParameter.class)
public class AfterTestNG 
	{
		@AfterMethod
		public void methodTearDown()
		{
			System.out.println("AfterMethod1");
		}
		@AfterClass
		public void classTearDown()
		{
			System.out.println("AfterClass1");
		}
		@AfterTest
		public void testTearDown()
		{
			System.out.println("AfterTest1");
		}
		@AfterSuite
		public void suiteTearDown()
		{
			System.out.println("AfterSuite1");
		}
		@BeforeSuite
		public void suiteSetup()
		{
			System.out.println("Before Suite1");
		}
		@BeforeTest
		public void testSetup()
		{
			System.out.println("BeforeTest1");
		}
		@Test
		public void test()
		{
			System.out.println("Test in BeforeNG1");
		}
		
		@BeforeClass
		public void classSetup()
		{
			System.out.println("BeforeClass1");
		}
		@BeforeMethod
		public void methodSetup()
		{
			System.out.println("BeforeMethod1");
		}
	}

