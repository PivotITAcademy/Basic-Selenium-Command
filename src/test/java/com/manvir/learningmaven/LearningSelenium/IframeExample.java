package com.manvir.learningmaven.LearningSelenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeExample {

	WebDriver driver;
	//JavascriptExecutor jse=(JavascriptExecutor) driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void switchToIframe() {
		driver.switchTo().frame("frame1");
		String headingTextFromFrame1 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(headingTextFromFrame1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		String headingTextFromFrame2 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(headingTextFromFrame2);
	}

	@AfterMethod
	public void tearDown() {
		// Close all the instances of that active browser
		driver.quit();
		driver.findElement(By.id("Munni"));
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
