package com.inetBanking.pageObject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
	
	WebDriver driver;
	WebDriverWait wait ;
	public LoginPOM(WebDriver driver) {
		this.driver = driver;	
	}
	
	By c_Button =By.xpath("//*[@alt='Cancel Icon']");
	By signup = By.xpath("//*[@class='nav-button menu-items-header nav-link ng-tns-c2721290124-2']");
	By ifra = By.xpath("//*[@data-tagging-id='G-DPGBLKH6P7']");
	By Mob_Num =By.xpath("//*[@ng-reflect-placeholder='Enter Mobile Number']");
	By Captcha = By.xpath("//*[text()='Verify Captcha']");
	By genrate_otp=By.xpath("//*[text()='Generate OTP']");
	By one=By.xpath("//*[@ng-reflect-name='one']");
	By two=By.xpath("//*[@ng-reflect-name='two']");
	By three=By.xpath("//*[@ng-reflect-name='three']");
	By four=By.xpath("//*[@ng-reflect-name='four']");
	By Submit =By.xpath("//*[text()='Submit OTP']");
	//By digi =By.xpath("(//*[@class='ms-3 ng-tns-c2980212703-1'])[2]");
	By know_More=By.xpath("(//*[text()='Know More'])[1]");
	By Quantity=By.xpath("//*[@ng-reflect-name='quantity']");
	By Quick_by =By.xpath("//*[text()='Quick Buy']");
	By Digi_Gold=By.xpath("//*[@id='dropdown-menu-item2']/a[text()='DIGI Gold']");
	By upi =By.xpath("//*[@alt='upi']");
	By pay_now =By.xpath("//*[text()='Pay Now']");
	
	
	

	public WebElement cancelButton() {
		return driver.findElement(c_Button);
	}

	public WebElement sign_up() {
		return driver.findElement(signup);
	}

	public void Switch_to_Sign_In() {
	/*	Set Windows=driver.getWindowHandles();
		Iterator itr =Windows.iterator();
		String parent = (String) itr.next();
		String frame=(String) itr.next();
		wait= new WebDriverWait(driver ,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Mob_Num));
		driver.switchTo().window(frame);
	*/
	}

	public WebElement Enter_Mobile_Num() {
		return driver.findElement(Mob_Num);
	}
	
	public WebElement Verify_Captcha_button() {
		return driver.findElement(Captcha);
	}
	
	public WebElement Generate_OTP_button() {
		return driver.findElement(genrate_otp);
	}
	
	public void Enter_OTP() {
		driver.findElement(one).sendKeys("1");
		driver.findElement(two).sendKeys("2");
		driver.findElement(three).sendKeys("3");
		driver.findElement(four).sendKeys("4");
	}
	
	public WebElement Click_Submit_Button() {
		return driver.findElement(Submit);
	}
	
	public WebElement Click_Digi_Gold() {
		return	driver.findElement(Digi_Gold);
		
	}
	
	public WebElement Click_Know_More() {
		return driver.findElement(know_More);
	}
	
	public WebElement Fill_Quantity() {
		return driver.findElement(Quantity);
	}
	
	public WebElement Click_Quick_Buy() {
		return driver.findElement(Quick_by);
	}
	
	public WebElement Select_UPI() {
		return driver.findElement(upi);
	}
	
	public WebElement pay_now() {
		return driver.findElement(pay_now);
	}
	
	public void Check_Payment_option_page() {
		boolean b =driver.getCurrentUrl().contains("order-summary");
		if(b== true) {
			System.out.println("You are on final payment option");
		}else {
			System.out.println("you are not on final payment option");
		}
		
	}
}
