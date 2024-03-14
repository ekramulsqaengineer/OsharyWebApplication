package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

     WebDriver driver;
     ExtentHtmlReporter htmlReporter;
     ExtentReports extent;
		@Test(priority=1)		
	    public static void main(String[] args) throws InterruptedException {

		  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		  
	        // create ExtentReports and attach reporter(s)
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        // creates a toggle for the given test, adds all log events under it    
	        
	        String projectPath= System.getProperty("user.dir");
			System.out.println(projectPath);
			System.setProperty("webdriver.chrome.driver", "/Users/afcuser/eclipse-workspace/OsharyWebApplication/drivers/chromedriver/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
		    extent.flush();
		
		}
		@Test
		public void Login() throws InterruptedException {
			ExtentTest test = extent.createTest("Oshary Apps", "Oshary E-commerce apps Test Case");
	        
	        test.log(Status.INFO, "Go to oshary.com");
	        driver.get("https://oshary.com/");
			//test.log(Status.INFO, "Go to oshary.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//a[normalize-space()='LOGIN/REGISTER']")).click();
			test.log(Status.INFO, "Click LOGIN/REGISTER Button");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='test@gmail.com / +8801234567892']")).sendKeys("ekram@logicwise.fi");
			test.log(Status.INFO, "Enter value ekram@logicwise.fi");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='user signin_form']//input[@type='password']")).sendKeys("ekram1234");
			test.log(Status.INFO, "Enter value ekram1234");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
			test.log(Status.INFO, "click submit button");
			
			Thread.sleep(2000);
			String msg = driver.findElement(By.id("swal2-title")).getText();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Start Shopping!']")).click();
			System.out.println(msg);
			if(msg.equals("Login Successful!")) {
				System.out.println("Test Pass");
				
			}else {
				System.out.println("Test Fail");
			}
			
		   test.log(Status.INFO, "Close The Brouser");
		   test.log(Status.INFO, "Test Complite");
		}
		
		@Test(priority=2)		
		public void LogOut() {
			ExtentTest test1 = extent.createTest("Oshary Apps", "Oshary E-commerce apps Test Case");
			driver.findElement(By.xpath("//a[normalize-space()='LOGOUT']")).click();
			test1.log(Status.INFO, "Test Complite");
			
			}
		@AfterTest
		public void tearDwonTest() {
			//driver.close();
			//driver.quit();
			//extent.flush();
		}
		


}
