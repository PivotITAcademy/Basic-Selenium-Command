package com.manvir.learningmaven.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationExamples {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Edge driver setup : System.setProperty("webdriver.edge.driver",
		// "F:\\Drivers\\Edge Driver\\msedgedriver.exe");

		// Open up the Chrome Browser
		driver = new ChromeDriver();

		// Opens up the Edge browser
		// driver = new EdgeDriver();

		// Load a URL on the browser than was opened.
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void navigationTest() {

		System.out.println("Before navigating the page title is " + driver.getTitle());
		sleep();
		// how to navigate to a different URL
		driver.navigate().to("https://www.google.com/");

		System.out.println("Before navigating the page title is " + driver.getTitle());
		sleep();
		
		// Navigate Backward
		driver.navigate().back();
		System.out.println("Before navigating back " + driver.getTitle());
		sleep();
		
		
		// Navigate Forward
		driver.navigate().forward();
		System.out.println("After navigating forward " + driver.getTitle());
		sleep();
		
		//Refresh Page
		driver.navigate().refresh();
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
