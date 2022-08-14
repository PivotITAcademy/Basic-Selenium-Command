package com.manvir.learningmaven.LearningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementReferenceExceptionExample {

	WebDriver driver;
	//JavascriptExecutor jse=(JavascriptExecutor) driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void staleElementRefExample() {
		WebElement email_Input1=driver.findElement(By.id("input-email"));
		driver.navigate().refresh();
		WebElement email_Input2=driver.findElement(By.id("input-email"));
		email_Input2.sendKeys("msp@it.com");
	}

	@AfterMethod
	public void tearDown() {
		// Close all the instances of that active browser
		sleep();
		driver.quit();

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
