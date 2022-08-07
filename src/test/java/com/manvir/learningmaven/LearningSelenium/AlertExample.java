package com.manvir.learningmaven.LearningSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

	WebDriver driver;
	// instantiate the action class
	Actions ac;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void acceptSimpleAlert() {
		// Clicking on button that shows up Alert
		driver.findElement(By.id("alertButton")).click();
		sleep();
		// Switch to Alert
		driver.switchTo().alert().accept();
		sleep();

	}

	@Test()
	public void confirmationAlert() {
		// Clicking on button that shows up Alert
		driver.findElement(By.id("confirmButton")).click();
		sleep();
		// Switch to Alert
		System.out.println("Accepting Alerts....!!!!!");
		driver.switchTo().alert().accept();
		sleep();

		// Clicking on button that shows up Alert
		driver.findElement(By.id("confirmButton")).click();
		sleep();
		// Switch to Alert
		System.out.println("Dismissing Alerts....!!!!!");
		driver.switchTo().alert().dismiss();
		sleep();

	}
	
	@Test()
	public void promptAlert() {
		// Clicking on button that shows up Alert
		driver.findElement(By.id("promtButton")).click();
		sleep();
		Alert al=driver.switchTo().alert();
		
		al.sendKeys("Wake Up");
		sleep();
		al.accept();
		sleep();
		

	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
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
