package com.manvir.learningmaven.LearningSelenium;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumFileUpload {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");

		// Open up the Chrome Browser
		driver = new ChromeDriver();

		// Load a URL on the browser than was opened.
		driver.get("https://demoqa.com/automation-practice-form");
		sleep();

		// maxmise the screen
		driver.manage().window().maximize();

	}

	@Test
	public void rightClickTestTest() {
		WebElement uploadLink = driver.findElement(By.id("uploadPicture"));
		//uploadLink.sendKeys("C:\\Users\\Owner\\Desktop\\Java Assignment 24102021.txt");
		
		uploadFile("C:\\Users\\Owner\\Java Assignment 24102021.txt",uploadLink);

	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		 driver.quit();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void uploadFile(String filePath,WebElement uploadElement) {
		try {
			uploadElement.sendKeys(filePath);
		} catch (Exception e) {
			System.out.println("File was not found");
		}
	}

}
