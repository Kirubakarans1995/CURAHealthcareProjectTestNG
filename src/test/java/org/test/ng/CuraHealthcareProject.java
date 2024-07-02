package org.test.ng;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CuraHealthcareProject extends BaseClass {
	
	
	
	@BeforeClass
	public static void beforeClass() {		
		
		chromeBrowser();
		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		maxWindow();
		applyImplicitWait(15);
		
	}
	
	@Test(priority = -5, groups = "smoke")
	public static void page1() throws IOException {
		
		String pageTitle = pageTitle();
		System.out.println("Title of the Page: "+pageTitle);
		
		boolean contains = pageTitle.contains("CURA");
		Assert.assertTrue(contains);
		
		String pageCurrentUrl = pageCurrentUrl();
		System.out.println("URL of the Page: "+pageCurrentUrl);
		
		boolean contains1 = pageCurrentUrl.contains("katalon-demo-cura");
		Assert.assertTrue(contains1);
		
		if(contains1 == true) {
			
			WebElement jsDown = driver.findElement(By.xpath("//strong[text()='CURA Healthcare Service']"));
			scrollDown(jsDown);
			
			WebElement addressText = driver.findElement(By.xpath("//p[text()='Atlanta 550 Pharr Road NE Suite 525']"));
			
			String text = addressText.getText();
			System.out.println("Address: "+text);
			
			WebElement phoneText = driver.findElement(By.xpath("//li[text()=' (678) 813-1KMS']"));
			
			String text2 = phoneText.getText();
			System.out.println("Phone Number: "+text2);
			
			WebElement emailText = driver.findElement(By.xpath("//a[text()='info@katalon.com']"));
			
			String text3 = emailText.getText();
			System.out.println("Email Id: "+text3);
			
			WebElement click = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
			btnClick(click);
			
		}
								
		else {
			
			System.out.println("URL doesn't contains it");
			
		}
		
	}
	
	@Parameters({"Username", "Password"})
	@Test(priority = -1, groups = "smoke")	
	public static void page2(String user, String pass) {	
		
		WebElement usernameText = driver.findElement(By.xpath("//input[@value='John Doe']"));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(user);
		String attribute = usernameText.getAttribute("value");
		System.out.println("Username: "+attribute);
		
		boolean startsWith = attribute.startsWith("John");
		Assert.assertTrue(startsWith);
		
		WebElement passwordText = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		String attribute2 = passwordText.getAttribute("value");
		System.out.println("Password: "+attribute2);
		
		Assert.assertEquals(attribute2, "ThisIsNotAPassword");
		
		
		if(attribute2.startsWith("This")) {
			
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			
		}
		
		else {
			
			System.out.println("It doesn't starts with This");
			
		}
		
	}	
			
	@Test(priority = 5, groups = "sanity")
	public static void page3() throws IOException {
							
		WebElement down = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
		
		scrollDown(down);
		
		WebElement select = driver.findElement(By.xpath("//select[@name='facility']"));
		
		selectMethodByVisibleText(select, "Hongkong CURA Healthcare Center");
		
		WebElement click = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
		clickJS(click);
		
		WebElement click1 = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
		clickJS(click1);
		
		driver.findElement(By.xpath("//input[@name='visit_date']")).sendKeys("22/10/2024");
		
		WebElement commentField = driver.findElement(By.xpath("//textarea[@name='comment']"));
		
		fillTextBox(commentField, "Thanks for the appointment");
		
		String attribute = commentField.getAttribute("value");
		
		Assert.assertEquals(attribute, "Thanks for the appointment");
		
		if(attribute.contains("appointment")) {
			
			driver.findElement(By.xpath("//button[text()='Book Appointment']")).click();
			
		}
		
		
		else {
			System.out.println("It doesn't contains the word Appointment");
		}
		
						
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File des = new File("C:\\Users\\ADMIN\\eclipse-workspace"
				+ "\\TestNgCuraHealthcareProject\\Screenshots\\Confirmation.png");
		
		FileUtils.copyFile(src, des);
		
	}	
		
		
		
	@Test(priority = 9, groups = "sanity")	
	public static void page4() {	
								
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		
		driver.findElement(By.xpath("//a[text()='History']")).click();
		
		WebElement down1 = driver.findElement(By.xpath("//strong[text()='CURA Healthcare Service']"));
		
		scrollDown(down1);
		
		WebElement clickJS = driver.findElement(By.xpath("//a[text()='Go to Homepage']"));
		clickJS(clickJS);
		
		driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
		
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		
		WebElement clickJS1 = driver.findElement(By.xpath("(//a[text()='Logout'])[2]"));
		clickJS(clickJS1);
		
	}						
	
	
//	@AfterClass
//	public void afterClass() {
//		closeBrowser();
//	}
	
	
	
}

	