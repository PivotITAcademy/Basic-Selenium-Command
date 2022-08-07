package com.manvir.learningmaven.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {

	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Edge driver setup : System.setProperty("webdriver.edge.driver",
		// "F:\\Drivers\\Edge Driver\\msedgedriver.exe");

		// Open up the Chrome Browser
		driver = new ChromeDriver();

		ac = new Actions(driver);

		// Opens up the Edge browser
		// driver = new EdgeDriver();

		// Load a URL on the browser than was opened.
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		sleep();
		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void mouseHover() {
		WebElement mouserHoverElement = driver.findElement(
				By.cssSelector("#content div.row:nth-of-type(4)>div.product-layout:first-of-type button:nth-of-type(2)"));

		ac.moveToElement(mouserHoverElement).perform();

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		//driver.close();
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
