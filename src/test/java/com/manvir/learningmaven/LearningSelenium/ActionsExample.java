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

public class ActionsExample {

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
		driver.get("https://demoqa.com/buttons");
		sleep();
		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void rightClickTestTest() {
		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

		ac.contextClick(rightClickBtn).perform();

		WebElement rightClickSuccessMessageElement = driver.findElement(By.id("rightClickMessage"));

		String message = rightClickSuccessMessageElement.getText();

		Assert.assertEquals(message, "You have done a right click", "Message doesn't match");

	}

	@Test
	public void doubleClick() {
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		ac.doubleClick(doubleClickBtn).perform();
		WebElement doubleClickSuccessMesage = driver.findElement(By.id("doubleClickMessage"));
		Assert.assertEquals(doubleClickSuccessMesage.getText(), "You have done a double click",
				"Message doesn't match");
	}

	@Test
	public void actionClick() {
		WebElement singleClick = driver.findElement(By.cssSelector("div.col-12.mt-4.col-md-6>div:nth-of-type(2)>div:nth-of-type(3) button"));
		ac.click(singleClick).perform();
		WebElement doubleClickSuccessMesage = driver.findElement(By.id("dynamicClickMessage"));
		Assert.assertEquals(doubleClickSuccessMesage.getText(), "You have done a dynamic click",
				"Message doesn't match");
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
