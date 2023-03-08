package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraDataBaseTesting1 {
	
	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new Driver());
		Connection connection = null;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url="http://rmgtestingserver:8084/";
		String userName = "rmgyantra";
		String password = "rmgy@9999";

		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(userName);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		String actWelcomePage=driver.findElement(By.xpath("//h2[text()='Welcome To Project Management System']")).getText();

		if(actWelcomePage.contains("Welcome To Project Management System")) {
			System.out.println("User signed in successfully");
		}else {
			System.out.println("User not signed in successfully");
		}

		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		String projectPage = driver.getCurrentUrl();

		if(projectPage.contains("projects")) {
			System.out.println("Project page displayed successfully");
		}else {
			System.out.println("Project page not displayed successfully");
		}

		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("API");
		driver.findElement(By.name("createdBy")).sendKeys("Rob");
		WebElement prjStatus = driver.findElement(By.name("status"));
		Select s= new Select(prjStatus);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		try {

			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from project where project_name = 'Vishwas' ; ");

			while(result.next())
			{
				String manager = result.getString("created_by");
				String project_Name = result.getString("project_name");
				String projectID = result.getString("project_id");
				String status = result.getString("status");
				String createdOn = result.getString("created_on");
				String NoOfEmp = result.getString("team_size");
				System.out.println(manager+" "+project_Name+" "+projectID+" "+status+" "+createdOn+" "+NoOfEmp);
			}
		}
		finally
		{
			connection.close();
			System.out.println("connection closed");
		}

	}

}


/*
	}
	 
	public static void main(String[] args) throws SQLException 
	{
		String url = "http://rmgtestingserver:8084/";
		String SignInPage = "Sign In";
		String WelcomePage = "Welcome To Project Management System";
		String ProjetLinkButton = "Projects";
		String ProjectList = "Projects";
		String CreatePagePopUp = "Create Project";
		String projectName = "Vishwas";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		String signIn = driver.findElement(By.xpath("//h5[. = 'Sign In']")).getText();
		if(signIn.equals(SignInPage))
		{
			System.out.println("Sign In Page is Displayed");
		}
		else
		{
			System.out.println("Sign In Page is not Displayed");
		}
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[. = 'Sign in']")).click();
		String welcome = driver.findElement(By.xpath("//h2[. = 'Welcome To Project Management System']")).getText();
		if(welcome.equals(WelcomePage))
		{
			System.out.println("Welcome Page is Displayed");
		}
		else
		{
			System.out.println("Welcome Page is not Displayed");
		}
		driver.findElement(By.xpath("//a[. = 'Projects']")).click();
		String projectList = driver.findElement(By.xpath("//b[. = ' Projects']")).getText();
		if(projectList.equals(ProjectList))
		{
			System.out.println("List of Project Page is Displayed");
		}
		else
		{
			System.out.println("List of Projecte Page is not Displayed");
		}
		driver.findElement(By.xpath("//span[. = 'Create Project']")).click();
		Set<String> parentBrowser = driver.getWindowHandles();
		for (String createPage : parentBrowser) 
		{
			driver.switchTo().window(createPage);
		}
		String createPagePopup = driver.findElement(By.xpath("//h4[. = 'Create Project']")).getText();
		if(createPagePopup.equals(CreatePagePopUp))
		{
			System.out.println("Create Page popup is Displayed");
		}
		else
		{
			System.out.println("Create Page popup is not Displayed");
		}
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("TestYantraSS");
		WebElement options = driver.findElement(By.xpath("//label[. = 'Project Status ']/following-sibling::select"));
		Select s = new Select(options);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class = 'btn btn-success']")).click();


		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);

		Connection connection = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			Statement statement = connection.createStatement();

			ResultSet result = statement.executeQuery("select * from project where project_name = 'Vishwas' ; ");

			while(result.next())
			{
				String manager = result.getString("created_by");
				String project_Name = result.getString("project_name");
				String projectID = result.getString("project_id");
				String status = result.getString("status");
				String createdOn = result.getString("created_on");
				String NoOfEmp = result.getString("team_size");
				System.out.println(manager+" "+project_Name+" "+projectID+" "+status+" "+createdOn+" "+NoOfEmp);
			}
		}
		finally
		{
			connection.close();
			System.out.println("connection closed");
		}

	}
*/


