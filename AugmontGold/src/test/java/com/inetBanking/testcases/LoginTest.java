package com.inetBanking.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPOM;
import com.inetBanking.utilities.ExtentReport;

public class LoginTest extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {
		driver.get(URL);
		log.info("open URL");

		LoginPOM obj = new LoginPOM(driver);

		obj.cancelButton().click();
		log.info("close advertisement popup");
		obj.sign_up().click();
		log.info("Click on signup button");
		obj.Enter_Mobile_Num().sendKeys("8380885882");
		log.info("Enter Mobile number");
		Thread.sleep(15000);//for Entering captcha manually.

		obj.Verify_Captcha_button().click();
		log.info("Verify captcha");
		Thread.sleep(5000);
		obj.Generate_OTP_button().click();
		log.info("Click on Generate OTP");
		obj.Enter_OTP();
		log.info("Enter OTP");
		obj.Click_Submit_Button().click();
		log.info("Click submit button");
		Thread.sleep(5000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//*[text()=' Products ']"))).build().perform();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(obj.Click_Digi_Gold())).click();
		obj.Click_Digi_Gold().click();
		log.info("Clicked on Digi Gold");
		Thread.sleep(5000);
		obj.Fill_Quantity().sendKeys("1");;
		log.info("Enter Quantity of Digi Gold");
		driver.findElement(By.xpath("//*[text()='₹ 1000']")).click();
		log.info("click on 1000 Rs");
		obj.Click_Quick_Buy().click();
		log.info("Click on quick buy");
		obj.pay_now();
		log.info("Pay now option selected");
		obj.Check_Payment_option_page();
		
		
		
	}

}
