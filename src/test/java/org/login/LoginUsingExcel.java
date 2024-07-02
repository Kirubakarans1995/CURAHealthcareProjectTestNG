package org.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginUsingExcel extends BaseClass {
	
	@BeforeClass
	public static void befClass() {
		
		chromeBrowser();
		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		maxWindow();
		applyImplicitWait(8);
		
	}
	
	@Test(priority = 4)
	public static void loginClick() {
		
		WebElement click = driver.findElement(By.xpath("//i[@class='fa fa-bars']"));
		clickMethod(click);
		WebElement clickLogin = driver.findElement(By.xpath("//a[text()='Login']"));
		clickMethod(clickLogin);
		
	}
	
	@Test(priority = 5)
	public static void loginFillDetails() throws IOException {
		
		WebElement user = driver.findElement(By.xpath("//input[@id='txt-username']"));
		clickMethod(user);
		fillTextBox(user, readFromExcel("Login", 1, 0));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		clickMethod(pass);
		fillTextBox(pass, readFromExcel("Login", 1, 1));
		WebElement click = driver.findElement(By.xpath("//button[@id='btn-login']"));
		clickMethod(click);
		
	}
	
	@Test(priority = 13)
	public static void takeSnap() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;		
		File src = ts.getScreenshotAs(OutputType.FILE);		
		File des = new File("C:\\Users\\ADMIN\\eclipse-workspace"
				+ "\\TestNgCuraHealthcareProject\\Screenshots\\LoginSuccess.png");		
		FileUtils.copyFile(src, des);
		
	}
	
//	@AfterClass
//	public static void aftClass() {
//		
//		closeBrowser();
//		
//	}
	
}