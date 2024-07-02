package org.test.ng;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Executable extends BaseClass{
	
	
	@Parameters({"Browser"})
	@Test
	public static void test(String browserName) {
		if(browserName.startsWith("chro")) {
			chromeBrowser();
			launchUrl("https://katalon-demo-cura.herokuapp.com/");
			maxWindow();
		}
		
		else if(browserName.equals("ff")) {
			firefoxBrowser();
			launchUrl("https://katalon-demo-cura.herokuapp.com/");
			maxWindow();
		}
		
		else {
			edgeBrowser();
			launchUrl("https://katalon-demo-cura.herokuapp.com/");
			maxWindow();
		}
	}

}