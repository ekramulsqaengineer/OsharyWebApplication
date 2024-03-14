package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithTestNG extends Base{
	
	ExtentHtmlReporter htmlReporter;
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
	   htmlReporter = new ExtentHtmlReporter("OsharyExtentReport.html"); 
	   //create ExtentReports and attach reporter(s)
	   extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
        
	}
	@BeforeTest
	public void beforetest() {
		String projectPath= System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", "/Users/afcuser/eclipse-workspace/OsharyWebApplication/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
	}
	 
	@Test
	public void test() throws IOException, InterruptedException {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Oshary Apps", "Oshary E-commerce apps Test Case");
      
        driver.get("https://oshary.com/");
		//test.log(Status.INFO, "Go to oshary.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='LOGIN/REGISTER']")).click();
		//test.log(Status.INFO, "Click LOGIN/REGISTER Button");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='test@gmail.com / +8801234567892']")).sendKeys("ekram@logicwise.fi");
		//test.log(Status.INFO, "Enter value ekram@logicwise.fi");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='user signin_form']//input[@type='password']")).sendKeys("ekram1234");
		//test.log(Status.INFO, "Enter value ekram1234");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
		//test.log(Status.INFO, "click submit button");
		
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("swal2-title")).getText();
		System.out.println(msg);
		if(msg.equals("Login Successful!")) {
			System.out.println("Test Pass");
			
		}else {
			System.out.println("Test Fail");
		}
        
        //test.log(Status.INFO, "Go to oshary.com");
        //test.info("test info");
        //test.fail("status");
        //test.addScreenCaptureFromPath("screenshot.png");
	}
	
	
	
	@AfterTest
	public void tearDwonTest() {
		driver.close();
		driver.quit();
	}
	@AfterSuite
	public void tearDwon() {
	extent.flush();
	}

}
