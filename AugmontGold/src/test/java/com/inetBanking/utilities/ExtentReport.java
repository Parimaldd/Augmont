package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.testcases.BaseClass;

public class ExtentReport extends BaseClass {
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	
	 
	@BeforeTest
	public void startReport() {
	         // Create an object of Extent Reports
	extent = new ExtentReports();
	spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
	extent.attachReporter(spark);
	extent.setSystemInfo("Host Name", "Parimal Todsam");
	extent.setSystemInfo("Environment", "Staging");
	extent.setSystemInfo("User Name", "Parimal Todsam");
	spark.config().setDocumentTitle("Title of the Report Comes here ");
	                // Name of the report
	spark.config().setReportName("Name of the Report Comes here ");
	                // Dark Theme
	spark.config().setTheme(Theme.STANDARD);
	}
	
	
	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/Screenshotsssssss/" + screenshotName + dateName + ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;
	}
	
	@AfterTest
	public void endReport() {
	extent.flush();
	}
	
}
