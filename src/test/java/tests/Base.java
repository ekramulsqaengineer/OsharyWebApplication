package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base extends ExtentReportsDemo{
	
	WebDriver driver;
	@BeforeTest
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/afcuser/Desktop/chromedriver");
		//String projectPath= System.getProperty("user.dir");
		//System.out.println(projectPath);
		//reportSetup();
//	    System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver");
	    
		//System.setProperty("webdriver.gecko.driver", "/Users/afcuser/eclipse-workspace/OsharyWebApplication/drivers/geckodriver/geckodriver");
		//WebDriver driver = new FirefoxDriver();
	    //ExtentTest test = extent.createTest("Oshary Apps", "Oshary E-commerce apps Test Case");
		
	     // log(Status, details)
	   // test.log(Status.INFO, "Test Login");
	    
	    
		
	}
	
	
	@Test
	public void sampleTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
	    
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
	   driver.close();
	   // calling flush writes everything to the log file
	   extent.flush();
		
		
	}
	
	@AfterTest
	public void tearDwon() {	
		
	}
	
	

}
