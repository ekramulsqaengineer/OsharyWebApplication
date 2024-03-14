package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;




public class SignupOshary extends Base{
	@Test
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://oshary.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='LOGIN/REGISTER']")).click();
		driver.findElement(By.xpath("//input[@placeholder='test@gmail.com / +8801234567892']")).sendKeys("ekram@logicwise.fi");
		driver.findElement(By.xpath("//div[@class='user signin_form']//input[@type='password']")).sendKeys("ekram1234");
		driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("swal2-title")).getText();
		System.out.println(msg);
		if(msg.equals("Login Successful!")) {
			System.out.println("Test Pass");
			
		}else {
			System.out.println("Test Fail");
		}
	   driver.close();

	}

}
