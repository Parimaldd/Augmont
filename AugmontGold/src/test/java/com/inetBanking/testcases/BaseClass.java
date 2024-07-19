package com.inetBanking.testcases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.inetBanking.utilities.ExtentReport;
import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String URL = readConfig.getApplicationURL(); // "https://cp.gfau.augmont.com/";
	public static WebDriver driver;
	WebDriverWait wait;
	public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String br) {
		// Multiple browser
		if (br.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", readConfig.getChromepath());
			driver = new ChromeDriver();
		} else {
			System.setProperty("WebDriver.edge.driver", readConfig.getEdgepath());
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		log = Logger.getLogger("AugmontGold");
		PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		log.info("Browser started");
		driver.get(URL);
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		log.info("Browser closed");
	}
}
