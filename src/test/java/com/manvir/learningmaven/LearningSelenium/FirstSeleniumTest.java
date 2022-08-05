package com.manvir.learningmaven.LearningSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

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
		driver.get("https://www.google.com/");

		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void test1() {
		String titleOfThePage = driver.getTitle();
		System.out.println("The Title of the Page is " + titleOfThePage);
		Assert.assertEquals(titleOfThePage,"Google" ,"Title doesn't match");

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.close();
	}

}
