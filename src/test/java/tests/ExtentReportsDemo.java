package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo{
	static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	@BeforeSuite
	public static void reportSetup() {
	  htmlReporter = new ExtentHtmlReporter("OsharyExtentReport.html"); 
		
		 // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
		  
	}
	
	@Test
	public void demoTest() {
		System.out.println("Hello");
		
	}
	
	
	@AfterSuite
	public void reportTeardown() {
		
		  // calling flush writes everything to the log file
        extent.flush();
	
	}

}
